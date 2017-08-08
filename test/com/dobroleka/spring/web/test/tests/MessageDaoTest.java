package com.dobroleka.spring.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dobroleka.spring.web.dao.Message;
import com.dobroleka.spring.web.dao.MessagesDao;
import com.dobroleka.spring.web.dao.User;
import com.dobroleka.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/dobroleka/spring/web/config/dao-context.xml",
		"classpath:com/dobroleka/spring/web/config/security-context.xml",
		"classpath:com/dobroleka/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoTest {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private MessagesDao messagesDao;

	@Autowired
	private DataSource dataSource;

	private User user1 = new User("Michal1", "Michal_Nadolny1", "hello_there1", "michal1@op.pl", true, "ROLE_USER");
	private User user2 = new User("Michal2", "Michal_Nadolny2", "hello_there2", "michal2@op.pl", true, "ROLE_ADMIN");
	private Message message1 = new Message("Test Subject 1", "Test content 1", "Isaac Newton", "isaac@op.com", user1.getUsername());
	private Message message2 = new Message("Test Subject 2", "Test content 2", "Isaac Newton", "isaac@op.com", user1.getUsername());
	private Message message3 = new Message("Test Subject 3", "Test content 3", "Isaac Newton", "isaac@op.com", user2.getUsername());

	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from messages");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testSave() {
		usersDao.create(user1);
		usersDao.create(user2);


	
		messagesDao.saveOrUpdate(message1);
		
	}
	@Test
	public void testSaveRetrieve() {
		usersDao.create(user1);
		usersDao.create(user2);

		
		messagesDao.saveOrUpdate(message1);
		messagesDao.saveOrUpdate(message2);
		messagesDao.saveOrUpdate(message3);
		
		List<Message> messages = messagesDao.getMessages(user1.getUsername());
		assertEquals(2, messages.size());
		
		messages = messagesDao.getMessages(user2.getUsername());
		assertEquals(1, messages.size());
	}
	
	@Test
	public void testRetrieveById() {
		usersDao.create(user1);
		usersDao.create(user2);
		
		messagesDao.saveOrUpdate(message1);
		messagesDao.saveOrUpdate(message2);
		messagesDao.saveOrUpdate(message3);
		
		List<Message> messages = messagesDao.getMessages(user1.getUsername());
		
		for(Message message: messages) {
			Message retrieved = messagesDao.getMessage(message.getId());
			assertEquals(message, retrieved);
		}
	}
	
	@Test
	public void testDelete() {
		usersDao.create(user1);
		usersDao.create(user2);
		
		messagesDao.saveOrUpdate(message1);
		messagesDao.saveOrUpdate(message2);
		messagesDao.saveOrUpdate(message3);
		
		List<Message> messages = messagesDao.getMessages(user1.getUsername());
		
		for(Message message: messages) {
			Message retrieved = messagesDao.getMessage(message.getId());
			assertEquals(message, retrieved);
		}
		
		Message toDelete = messages.get(1);
		
		assertNotNull("This message not deleted yet.", messagesDao.getMessage(toDelete.getId()));
		
		messagesDao.delete(toDelete.getId());
		
		assertNull("This message was deleted.", messagesDao.getMessage(toDelete.getId()));
	}

}
