package application.user;

import dao.UserDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * Created by hamish on 10/05/17.
 */

@RestController
public class UserController {

    @CrossOrigin
    @RequestMapping(value = "/users/{username}")
    public User user(@PathVariable String email) throws UnknownHostException {
        return UserDAO.getUserByEmail(email);
    }

    @CrossOrigin
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<User> newUser(@RequestBody User user) throws UnknownHostException {
        user.setDateCreated(new Date());
        UserDAO.addNewUser(user);
        User tested = UserDAO.getUserByEmail(user.getEmail());
        return new ResponseEntity<User>(tested == null ? HttpStatus.EXPECTATION_FAILED : HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final UserLogin login) throws ServletException, UnknownHostException {
        String message = "No message!";
        if (login.email == null){
            message = "Email can not be null";
            System.out.println("LOG: INVALID LOGIN: BODY: " + login.toString() + ", email: " + login.getEmail() + " , password: " + login.getPassword());
            throw new ServletException("Email can not be null");
        }
        if (!UserDAO.checkUserExisits(login.email)){
            message = "That user does not exist!";
            System.out.println("LOG: INVALID LOGIN: BODY: " + login.toString() + ", email: " + login.getEmail() + " , password: " + login.getPassword());
            throw new ServletException("That user does not exist!");
        }
        if(!login.password.equals(UserDAO.getUserByEmail(login.email).getPassword())){
            message = "Incorrect Password!";
            System.out.println("LOG: INVALID LOGIN: BODY: " + login.toString() + ", email: " + login.getEmail() + " , password: " + login.getPassword());
            throw new ServletException("Incorrect Password!");
        }

        User user = UserDAO.getUserByEmail(login.email);

        System.out.println("Logged from UserController.login: val of: user : " + user.toString());

        return new LoginResponse(Jwts.builder().setSubject(login.email)
                .claim("roles", UserDAO.getUserByEmail(login.email)).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "SECRET_KEY_NEEDS_UPDATING_EH_BRO").compact(), user.getEmail(), user.getRole(), user.getAccountBalance(), user.getTotalBidsMade(), message);
    }

    private static class UserLogin {
        public String email;
        public String password;
        public String getPassword() {
            return password;
        }
        public String getEmail(){
            return email;
        }
    }

    private static class LoginResponse {
        public String token;
        public String email;
        public String role;
        public Integer userAccountBalance;
        public Integer totalBidsMade;
        public String message;
        public LoginResponse(final String token, final String email, final String role, final Integer userAccountBalance, final Integer totalBidsMade,final String message) {
            this.token = token;
            this.email = email;
            this.role = role;
            this.userAccountBalance = userAccountBalance;
            this.totalBidsMade = totalBidsMade;
            this.message = message;
        }
    }
}
