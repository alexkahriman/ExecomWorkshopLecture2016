package eu.execom.workshops.workshoplecture.api;

import java.util.ArrayList;
import java.util.List;

import eu.execom.workshops.workshoplecture.model.User;

/**
 * This is a dummy user repository. Represents the backend/server side of user authentication logic.
 * Created by Alex on 10/17/16.
 */

public class ApiService {

    private final List<User> users = new ArrayList<>();

    public ApiService() {
        users.add(new User("Alex", "123"));
        users.add(new User("Luxa", "123"));
    }

    /**
     * Iterates over the user store in search of the user with given credentials.
     * @param username Username of the user attempting authentication.
     * @param password Password of the user attempting authentication.
     * @return {@link User User} if authentication is successful, otherwise null.
     */
    public User authenticate(String username, String password) {
        for (User user: users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
