package SWIapp.NotificationSendingTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class NotificationSendingTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSendingTwoApplication.class, args);
	}

}
