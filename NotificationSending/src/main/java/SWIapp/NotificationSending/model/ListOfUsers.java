package SWIapp.NotificationSending.model;

import org.springframework.stereotype.Repository;

@Repository
public class ListOfUsers {

    //Method which create new user if user name isn't null or empty
    public static User takeUser(String userName) {
        if (userName == null || userName.toLowerCase().equals("empty")) {
            throw new RuntimeException("User name is null or empty");
        }
        return User.createUser(userName);
    }
}
