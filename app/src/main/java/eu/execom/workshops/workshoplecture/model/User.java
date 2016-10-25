package eu.execom.workshops.workshoplecture.model;

/**
 * Model representing the app user.
 * Created by Alex on 10/17/16.
 */

public class User {

    private final String username;

    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
