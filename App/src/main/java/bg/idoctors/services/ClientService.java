/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.services;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientRegistrationForm;

public interface ClientService {
	public Client registerNewClientAccount(ClientRegistrationForm clientRegistrationForm);
}
