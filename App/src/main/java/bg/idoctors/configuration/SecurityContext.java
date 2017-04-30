/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import bg.idoctors.domain.Client;
import bg.idoctors.models.ClientSocialDetails;
import bg.idoctors.repositories.ClientDetailRepositoryService;
import bg.idoctors.repositories.ClientRepository;
import bg.idoctors.services.impl.SocialClientDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter{
	@Qualifier
	private ApplicationContext applicationContext;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SuccessHandler successHandler;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/auth/facebook")
				.loginProcessingUrl("/login/authenticate")
				.successHandler(successHandler)
				.failureUrl("/login?error=bad_credintials")
			.and()
				.logout()
					.deleteCookies("JSESSIONID")
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
			.and()
				.authorizeRequests()
					.antMatchers("/auth/**", 
								"/login",
								"/signin/**", 
								"/signup/**", 
								"/client/register/**").permitAll()
					.antMatchers("/*").hasRole("USER")
			.and()
				.apply(new SpringSocialConfigurer())
			.and()
				.setSharedObject(ApplicationContext.class, applicationContext);
	}
	
	public static void loginInUser(Client client){
		ClientSocialDetails clientDetails = ClientSocialDetails.getBuilder()
											.id(client.getId())							
											.firstName(client.getFirstName())
											.lastName(client.getLastName())
											.role(client.getRole())
											.socialSignInProvider(client.getSocialMediaSignInProvider())
											.build();
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	
	    Authentication authentication = new UsernamePasswordAuthenticationToken(clientDetails, null, authorities);		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public SocialUserDetailsService socialUserDetailService(){
		return new SocialClientDetailsServiceImpl(userDetailsService());
	}
	
	@Bean
	public UserDetailsService userDetailsService(){
		return new ClientDetailRepositoryService(clientRepository);
	}
	
	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
}
