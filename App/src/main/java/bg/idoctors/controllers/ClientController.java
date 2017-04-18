/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.controllers;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import bg.idoctors.domain.Client;
import bg.idoctors.models.SocialMediaService;
import bg.idoctors.services.ClientService;

@Controller
@SessionAttributes("client")
public class ClientController {
	@Autowired
	private ClientService service;
	
	private ProviderSignInUtils providerSignInUtils;

	@Inject
	public ClientController(ClientService service, 
		                    ConnectionFactoryLocator connectionFactoryLocator,
		                    UsersConnectionRepository connectionRepository) {
		this.service = service;
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
	}
	
	@RequestMapping(value ="/client/register")
	private Client createClientAccount(Client client, BindingResult result, WebRequest request) {
		Client registered = null;
		
		try {
			Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
	    
			Facebook facebook = (Facebook) connection.getApi();
			String [] fields = { "id", "email",  "first_name", "last_name", "picture"};
			org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
			
			client = new Client.Builder()
							   .id(userProfile.getId())
							   .email(userProfile.getEmail())
							   .firstName(userProfile.getFirstName())
							   .lastName(userProfile.getLastName())
							   .profilePicture(facebook.userOperations().getUserProfileImage())
							   .socialMediaSignInProvider(SocialMediaService.FACEBOOK)
							   .build();
			
			registered = service.registerNewClientAccount(client);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return registered;
	}
}
