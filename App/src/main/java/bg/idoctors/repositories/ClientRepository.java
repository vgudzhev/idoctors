package bg.idoctors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientSocialDetails;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	public ClientSocialDetails findByEmail(String email);
}
