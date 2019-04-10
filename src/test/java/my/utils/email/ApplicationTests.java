package my.utils.email;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	EmailUtils eu;
	
	@Test
	public void contextLoads() throws MessagingException {
		
		log.info("Sending plain text email...");
		eu.sendEmail("james.wang@digicert.com", "james.wang@digicert.com", "Plain Text Email Testing", "Plain text body.");
		
		log.info("Sending HTML email...");
		eu.sendEmailHtml("james.wang@digicert.com", "james.wang@digicert.com", "HTML Email Testing", "<a href='www.google.com'>Google</a>");
	}

}
