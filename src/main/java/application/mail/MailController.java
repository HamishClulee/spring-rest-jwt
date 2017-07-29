package application.mail;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hamish on 27/07/17.
 */
@RestController
public class MailController {
//
//    @CrossOrigin
//    @RequestMapping(value = "/mail/{userid}")
//    public List<Mail> getAllMail(@PathVariable String userid) throws UnknownHostException {
//        return MailDAO.getAllMail();
//    }
//
//    @CrossOrigin
//    @RequestMapping("/mail/{userid}/auction-winners")
//    public List<Mail> getAllWinners() throws UnknownHostException {
//        return MailDAO.getAllWinningBids();
//    }
//
//    @CrossOrigin
//    @RequestMapping("/mail/{userid}/notifications")
//    public List<Mail> getAllNotifications() throws UnknownHostException {
//        return AuctionDAO.getAllClosedAuctions();
//    }



}
