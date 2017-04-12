/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.models;

import org.springframework.social.security.SocialUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class ClientSocialDetails extends SocialUser {
	private Integer id;
	private String firstName;
	private String lastName;
	private Role role;
	private SocialMediaService socialMediaProvider;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SocialMediaService getSocialMediaProvider() {
		return socialMediaProvider;
	}

	public void setSocialMediaProvider(SocialMediaService socialMediaProvider) {
		this.socialMediaProvider = socialMediaProvider;
	}

	public ClientSocialDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
    }

	public static class Builder {
		private Integer id;
		private String username;
		private String firstName;
		private String lastName;
		private String password;
		private Role role;
		private SocialMediaService socialMediaProvider;
		private Set<GrantedAuthority> authorities;
		
		public Builder(){
			this.authorities = new HashSet<>();
		}
		
		public Builder id(Integer id){
			this.id = id;
			return this;
		}
		
		public Builder username(String username){
			this.username = username;
			return this;
		}
		
		public Builder firstName(String firstName){
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}
		
		public Builder password(String password){
			if(password == null){
				this.password = "SocialUserLogin";
			}
			
			this.password = password;
			
			return this;
		}
		
		public Builder role(Role role){
			this.role = role;
			
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
			this.authorities.add(authority);
			
			return this;
		}
		
		public Builder socialSignInProvider(SocialMediaService socialSignInprovider){
			this.socialMediaProvider = socialSignInprovider;
			return this;
		}
		
		
		public ClientSocialDetails build() {
			ClientSocialDetails client = new ClientSocialDetails(username, password, authorities);
			
			client.id = id;
			client.firstName = firstName;
			client.lastName = lastName;
			client.role = role;
			client.socialMediaProvider = socialMediaProvider;
			
			return client;
		}
	}
}
