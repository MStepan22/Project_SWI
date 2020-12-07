package SWIapp.NotificationSending.model;

public class User {

    private String userName;

    //Constructor without parameters
    public User() {

    }

    //Method which create new user with name
    //Měla by být static? -> házelo to chybu v MessageController
    public static User createUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        return user;
    }

    //Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
