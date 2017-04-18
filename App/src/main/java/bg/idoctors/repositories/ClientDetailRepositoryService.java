/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.idoctors.models.ClientSocialDetails;

public class ClientDetailRepositoryService implements UserDetailsService{
	
	private ClientRepository clientRepository;
	
	public ClientDetailRepositoryService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ClientSocialDetails client = clientRepository.findByEmail(email);
		
		if(client == null){
			throw new UsernameNotFoundException("No user found wih email: " + email);
		}
		
		ClientSocialDetails clientSocialDetails = new ClientSocialDetails.Builder()
		.id(client.getId())
		.firstName(client.getFirstName())
		.lastName(client.getLastName())
		.role(client.getRole())
		.socialSignInProvider(client.getSocialMediaProvider())
		.build();
											
		return clientSocialDetails;
	}

}
