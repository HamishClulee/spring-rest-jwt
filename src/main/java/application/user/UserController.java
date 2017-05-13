package application.user;

import dao.UserDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hamish on 10/05/17.
 */
@CrossOrigin
@RestController
public class UserController {

    @RequestMapping(value = "/users/{username}")
    public User user(@PathVariable String username) throws UnknownHostException {
        User user = UserDAO.getUserByUserName(username);
        return new User(user.getUsername(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getDateCreated(), user.getPassword());
    }

    @RequestMapping("/users")
    public List<User> getAllUsers() throws UnknownHostException {
        List<User> users = UserDAO.getAllUsers();
        return users;
    }

}
