/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.repositories;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientSocialDetails;

public class ClientDetailRepositoryService implements UserDetailsService{
	
	private ClientRepository clientRepository;
	
	public ClientDetailRepositoryService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClientSocialDetails client = clientRepository.findByEmail(username);
		
		if(client == null){
			throw new UsernameNotFoundException("No user found wih username: " + username);
		}
		
		ClientSocialDetails clientSocialDetails = new ClientSocialDetails.Builder()
		.id(client.getId())
		.username(client.getUsername())
		.firstName(client.getFirstName())
		.lastName(client.getLastName())
		.password(client.getPassword())
		.role(client.getRole())
		.socialSignInProvider(client.getSocialMediaProvider())
		.build();
											
		return clientSocialDetails;
	}

}
