package SWIapp.NotificationSending.controller;

import SWIapp.NotificationSending.model.ListOfUsers;
import SWIapp.NotificationSending.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/msq")
public class MessageController {

    private final String messageDestination;
    private final JmsTemplate jmsTemplate;
    private final ListOfUsers listOfUsers;

    public MessageController(@Value("${message.destination}") String messageDestination, JmsTemplate jmsTemplate, ListOfUsers listOfUsers) {
        this.messageDestination = messageDestination;
        this.jmsTemplate = jmsTemplate;
        this.listOfUsers = listOfUsers;
    }

    @GetMapping("/findUser/{userName}")
    @Transactional
    //Method which ...?
    public String findUserTransactional(@PathVariable String userName) {
        jmsTemplate.convertAndSend(messageDestination, String.format("Search for user '%s' has begun.", userName));
        User taked = ListOfUsers.takeUser(userName);
        jmsTemplate.convertAndSend(messageDestination, String.format("Search for user '%s' has finished.", userName));
        return String.format("User found '%s'.", taked.getUserName());
    }
}
