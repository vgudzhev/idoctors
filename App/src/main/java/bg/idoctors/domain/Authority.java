/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{

	@Id
    @Column(unique = true, nullable = false)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private List<Client> clients = new ArrayList<>();
    
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
