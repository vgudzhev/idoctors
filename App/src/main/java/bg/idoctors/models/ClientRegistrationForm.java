/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ClientRegistrationForm {
	
	@Email
	@NotEmpty
	@Size(max = 100)
	private String email;
	
	@NotEmpty
	@Size(max = 100)
	private String firstName;

	@NotEmpty
	@Size(max = 100)
	private String lastName;
	
	private String password;
	
	private String passwordVerification;
	
	private SocialMediaService signInProvider;
	
	public boolean isSocialSignIn(){
		return signInProvider != null;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerification() {
		return passwordVerification;
	}

	/**
	 * @param passwordVerification the passwordVerification to set
	 */
	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}

	public SocialMediaService getSignInProvider() {
		return signInProvider;
	}

	/**
	 * @param signInProvider the signInProvider to set
	 */
	public void setSignInProvider(SocialMediaService signInProvider) {
		this.signInProvider = signInProvider;
	}
}
