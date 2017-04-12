/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.configuration;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

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

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/auth/facebook")
				.loginProcessingUrl("/login/authenticate")
				.failureUrl("/login?error=bad_credintials")
			.and()
				.logout()
					.deleteCookies("JSESSIONID")
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
			.and()
				.authorizeRequests()
					.antMatchers("/auth/**", "/login", 
								"/signin/**", "/signup/**", 
								"/user/register/**").permitAll()
					.antMatchers("/**").hasRole("USER")
			.and()
				.apply(new SpringSocialConfigurer())
			.and()
				.setSharedObject(ApplicationContext.class, applicationContext);
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
