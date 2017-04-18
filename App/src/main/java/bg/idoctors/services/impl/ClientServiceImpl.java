package bg.idoctors.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientRegistrationForm;
import bg.idoctors.models.ClientSocialDetails;
import bg.idoctors.repositories.ClientRepository;
import bg.idoctors.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Override
	public Client registerNewClientAccount(Client client) {
		return clientRepository.save(client);
	}

}
