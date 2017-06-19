package net.slipp.dao.users;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.slipp.domain.users.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void findById() {		
		User user = userDao.findById("xx");
		logger.debug("User : {}", user);
	}
	
	@Test
	public void create() {		
		User user = new User("yy", "yy", "yy", "yy@nate.com");
		userDao.create(user);
		
		User actual = userDao.findById(user.getUserId());
		assertThat(actual, is(user));
		
		logger.debug("User : {}", user);
	}

}
