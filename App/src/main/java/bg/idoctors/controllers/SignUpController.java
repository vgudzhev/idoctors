/**
 * @author Shukri Shukriev
 *
 */
package bg.idoctors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String redirectRequestToRegistrationPage(){
		return "redirect:/client";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String redirectRequestToFacebookLogin(){
		return "redirect:/client";
	}	
	
}
