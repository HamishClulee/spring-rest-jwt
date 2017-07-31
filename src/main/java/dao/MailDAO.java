package dao;

import application.Mail.Mail;
import application.auction.Auction;
import application.bid.Bid;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

import static dao.MongoConnection.morphia;
import static dao.MongoConnection.uri;

/**
 * Created by hamish on 31/07/17.
 */
public class MailDAO {

    public static Datastore getConnection() throws UnknownHostException {
        morphia.map(Auction.class);
        return morphia.createDatastore(new MongoClient(uri), "dev");
    }

    public static void saveMail(Mail mail) throws UnknownHostException {
        getConnection().save(mail);
    }

    public static List<Mail> getAllMail() throws UnknownHostException {
        return getConnection().createQuery(Mail.class).asList();
    }

    public static List<Mail> getAllMailForUser(String userId) throws UnknownHostException {
        return getAllMail().stream().filter(b -> b.getMailSummary().getUserId().equals(userId)).collect(Collectors.toList() );
    }
}
