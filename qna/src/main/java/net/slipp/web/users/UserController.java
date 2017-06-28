package net.slipp.web.users;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.validation.Valid;

import net.slipp.dao.users.UserDao;
import net.slipp.domain.users.Authenticate;
import net.slipp.domain.users.User;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/form")
	public String form(Model model) {
		//form.jsp에서 modelAttribute="user" 로  호출하여 사용
		model.addAttribute("user", new User());
		return "users/form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		logger.debug("User : {}", user);
		if (bindingResult.hasErrors()) {
			logger.debug("바인딩 결과 에러~~~");
			List<ObjectError> errors = bindingResult.getAllErrors();
			
			for (ObjectError error : errors) {
				logger.debug("error{}, {}", error.getCode(), error.getDefaultMessage());
			}
			
			return "users/form"; 
		}
		userDao.create(user);
		logger.debug("Database : {}", userDao.findById(user.getUserId()));
		
		//첫 메인화면으로
		return "redirect:/";
	}
	
	@RequestMapping("/login/form")
	public String loginForm(Model model) {
		model.addAttribute("authenticate", new Authenticate());
		
		return "users/login";
	}
	
	@RequestMapping("/login")
	public String login(@Valid Authenticate authenticate, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "users/login";
		}
		
		User user = userDao.findById(authenticate.getUserId());
		if (user == null) {
			
		}
		
		if (user.getPassword().equals(authenticate.getPassword())) {
			
		}
		
		
		return "users/login";
	}
}
