package net.slipp.web.users;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.slipp.dao.users.UserDao;
import net.slipp.domain.users.User;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String create(User user) {
		logger.debug("User : {}", user);
		userDao.create(user);
		logger.debug("Database : {}", userDao.findById(user.getUserId()));
		
		return "users/form";
	}
}
