package dao;

import application.bid.Bid;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Bid> getAllBids() throws UnknownHostException {
        return getConnection().createQuery(Bid.class).asList();
    }

    public static  List<Bid> allBidsByAuctionId(Integer auctionId) throws UnknownHostException {
        return getAllBids().stream().filter(b -> b.getAuctionId().equals(auctionId)).collect(Collectors.toList());
    }

    public static List<Bid> allBidsByAuctionIdAndUserId(Integer auctionId, String email) throws UnknownHostException{
        return allBidsByAuctionId(auctionId).stream().filter(b -> b.getUserEmail().equals(email)).collect(Collectors.toList());
    }

}
