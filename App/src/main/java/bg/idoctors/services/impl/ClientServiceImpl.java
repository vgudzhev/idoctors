package bg.idoctors.services.impl;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientRegistrationForm;
import bg.idoctors.repositories.ClientRepository;
import bg.idoctors.services.ClientService;

public class ClientServiceImpl implements ClientService{
	
	private ClientRepository clientRepository;
	@Override
	public Client registerNewClientAccount(ClientRegistrationForm clientRegistrationForm) {
		System.out.println("We are here");
		// TODO Auto-generated method stub
		return null;
	}

}
