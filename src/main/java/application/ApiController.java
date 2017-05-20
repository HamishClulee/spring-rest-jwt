package application;

/**
 * Created by hamish on 14/05/17.
 */
import application.user.User;
import dao.UserDAO;
import io.jsonwebtoken.Claims;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ApiController {

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Boolean login(@PathVariable final String role,
                         final HttpServletRequest request) throws ServletException {
        final Claims claims = (Claims) request.getAttribute("claims");

        return ((List<String>) claims.get("roles")).contains(role);
    }

    @CrossOrigin
    @RequestMapping("users")
    public List<User> getAllUsers() throws UnknownHostException {
        List<User> users = UserDAO.getAllUsers();
        return users;
    }
}