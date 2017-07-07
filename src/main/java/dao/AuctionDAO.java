package dao;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;

import application.auction.Auction;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateOperator;

/**
 * Created by hamish on 9/05/17.
 */
public class AuctionDAO extends MongoConnection{

    public static Datastore getConnection() throws UnknownHostException {
        morphia.map(Auction.class);
        return morphia.createDatastore(new MongoClient(uri), "dev");
    }

    public static List<Auction> getAllAuctions() throws UnknownHostException {
        return getConnection().createQuery(Auction.class).asList();
    }

    public static void addNewAuction(Auction auction) throws UnknownHostException {
        getConnection().save(auction);
    }

    public static Auction getAuctionByID(Integer id) throws UnknownHostException {
        return getConnection().get(Auction.class, id);
    }

    public static void deleteAuction(String id) throws UnknownHostException{
        getConnection().delete(Auction.class, id);
    }

    public static void updateAuctionDetails(String AuctionIDToBeUpdated, Auction updatedAuction) throws UnknownHostException{
        Datastore ds = getConnection();
        ds.delete(Auction.class, AuctionIDToBeUpdated);
        ds.save(updatedAuction);
    }

    public static void makeBid(Integer id) throws UnknownHostException {
        Datastore ds = getConnection();
        UpdateOperations ops = ds.createUpdateOperations(Auction.class).inc("currentAmount");
        ds.update(getConnection().get(Auction.class, id), ops);
    }
    
}
