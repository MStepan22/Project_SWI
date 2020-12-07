package SWIapp.NotificationSendingTwo.commandLine;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageWriter {

    @JmsListener(destination = "${message.destination}")
    @Transactional
    public void consumeMessage(@Payload String payload) {
        System.out.printf("Taked message: '%s'.\n", payload);
    }
}
