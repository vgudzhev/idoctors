/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import bg.idoctors.models.ClientSocialDetails;

public class SocialClientDetailsServiceImpl implements SocialUserDetailsService{
	private UserDetailsService clientDetailsService;
	
	public SocialClientDetailsServiceImpl(UserDetailsService userDetailsService) {
		this.clientDetailsService = userDetailsService;
	}
	
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		UserDetails clientDetails = clientDetailsService.loadUserByUsername(userId);
		return (SocialUserDetails)clientDetails;
	}

}
