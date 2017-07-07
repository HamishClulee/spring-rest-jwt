package dao;

import application.Bid.Bid;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;

import java.net.UnknownHostException;

import static dao.MongoConnection.morphia;

/**
 * Created by hamish on 7/07/17.
 */
public class BidDAO {

    public static Datastore getConnection() throws UnknownHostException {
        morphia.map(Bid.class);
        return morphia.createDatastore(new MongoClient(MongoConnection.uri), "dev");
    }

    public static void saveBid(Bid bid) throws UnknownHostException {
        getConnection().save(bid);
    }
}
