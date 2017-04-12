/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import bg.idoctors.models.Role;
import bg.idoctors.models.SocialMediaService;

@Entity
@Table(name = "clients")
public class Client{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name = "first_name", length = 100)
	private String firstName;
	
	@Column(name = "last_name", length = 100)
	private String lastName;
	
	@Column(name = "password", length = 255)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 30, nullable = false)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sing_in_provider")
	private SocialMediaService socialMediaSignInProvider;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "client_have_authorities",
        	joinColumns = @JoinColumn(name = "clientId"),
        	inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private List<Authority> authorities = new ArrayList<>();
	
	public Client(){
		
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + ", socialMediaSignInProvider="
				+ socialMediaSignInProvider + "]";
	}
	
}
