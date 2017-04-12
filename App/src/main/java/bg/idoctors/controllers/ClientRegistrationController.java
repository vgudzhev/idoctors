/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.controllers;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import bg.idoctors.models.ClientRegistrationForm;
import bg.idoctors.models.SocialMediaService;
import bg.idoctors.services.ClientService;

@Controller
@SessionAttributes("client")
public class ClientRegistrationController {
	private ClientService clientService;
	
	public void hanleClientSingUp(WebRequest request) {
		Connection<?> connection = ProviderSignInUtils.getConnection(request);
	}
	
	private ClientRegistrationForm createRegistrationDTO(Connection<?> connection) {
		ClientRegistrationForm dto = new ClientRegistrationForm();
		
		if(connection != null) {
			UserProfile socialMediaProfile = connection.fetchUserProfile();
			
			dto.setEmail(socialMediaProfile.getEmail());
			dto.setFirstName(socialMediaProfile.getFirstName());
			dto.setLastName(socialMediaProfile.getLastName());
			
			ConnectionKey providerKey = connection.getKey();
			
            dto.setSignInProvider(SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase()));
		}
		return dto;
	}
}
