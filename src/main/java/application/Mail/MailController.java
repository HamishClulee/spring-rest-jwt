package application.Mail;

import dao.MailDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hamish on 1/08/17.
 */
@RestController
public class MailController {

    @CrossOrigin
    @RequestMapping(value = "/usermail/{username}")
    public List<Mail> maillByUser(@PathVariable String username) throws UnknownHostException {
        return MailDAO.getAllMailForUser(username);
    }


}
