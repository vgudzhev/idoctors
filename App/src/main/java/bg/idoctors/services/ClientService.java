/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.services;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientSocialDetails;

public interface ClientService {
	public Client registerNewClientAccount(Client client);
}
