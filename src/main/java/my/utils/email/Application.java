package my.utils.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// TODO: locale based email templates
	// TODO: watch folder for new acct. list file
	// TODO: REST API to submit acct. list
	// TODO: Web UI to submit acct. list
}
