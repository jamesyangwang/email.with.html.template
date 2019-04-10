package my.utils.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
    private JavaMailSender mailSender;
	
	public void sendEmail(final String from, final String to, final String subject, final String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to.split(","));	// 'to' list is comma separated string
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailSender.send(mailMessage);
	}
	
	public void sendEmailWithAttachment(final String from, final String to, final String subject, final String body, final String fileFullPathName) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(to.split(","));	// 'to' list is comma separated string
		helper.setSubject(subject);
		helper.setText(body);

		File attachment = new File(fileFullPathName);
		FileSystemResource file = new FileSystemResource(attachment);
		helper.addAttachment(attachment.getName(), file);
		
		mailSender.send(message);
	}

	public void sendEmailHtml(final String from, final String to, final String subject, final String body) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(to.split(","));	// 'to' list is comma separated string
		helper.setSubject(subject);
		helper.setText(body, true);
		
		mailSender.send(message);
	}
}