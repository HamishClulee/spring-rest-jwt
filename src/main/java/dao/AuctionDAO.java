package dao;

import application.Bid.Bid;
import application.auction.AuctionWinner;
import application.auction.ClosedAuction;
import application.user.User;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import application.auction.Auction;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;

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

    public static Auction bidReturnAuction(Integer id, String userEmail) throws UnknownHostException {
        Datastore ds = getConnection();
        // increment the auction current amount
        UpdateOperations incAmount = ds.createUpdateOperations(Auction.class).inc("currentAmount");
        ds.update(getConnection().get(Auction.class, id), incAmount);
        // decrement the users account balance
        UpdateOperations decBalance = ds.createUpdateOperations(User.class).dec("accountBalance");
        ds.update(getConnection().get(User.class, userEmail), decBalance);
        // return the auction
        return getConnection().get(Auction.class, id);
    }

    public static void winningBidRecieved(Integer auctionId) throws UnknownHostException {
        // get the auction that is completed into memory
        Auction auction = getConnection().get(Auction.class, auctionId);
        // delete it from the active table
        getConnection().delete(Auction.class, auctionId);
        // create the ClosedAuction with the finished auction details
        ClosedAuction closedAuction = new ClosedAuction(auctionId, auction.getName(), auction.getReserve(), new Date());
        // save the ClosedAuction
        getConnection().save(closedAuction);
        // ---------- DETERMINE THE WINNER OF THE AUCTION ------------- //
        // Filter the bids table for all the bids that relate to the completed auction
        List<Bid> auctionBids = BidDAO.getAllBids().stream().filter(b -> b.getAuctionId().equals(auctionId)).collect(Collectors.toList());
        // create a new auction winner using the reserve of the closed auction as the index in the bids list
        getConnection().save(new AuctionWinner(auctionId, auctionBids.get(auction.getReserve() - 1).getUserEmail()));
    }

    public static List<AuctionWinner> getAllAuctionWinners() throws UnknownHostException {
        return getConnection().createQuery(AuctionWinner.class).asList();
    }

    public static List<ClosedAuction> getAllClosedAuctions() throws UnknownHostException {
        return getConnection().createQuery(ClosedAuction.class).asList();
    }

    // ------- DROP ALL ENTRIES FROM TESTING TABLES ------------------ //
    public static void drop_Bids_Winners_Closed() throws UnknownHostException {
        dropBidTable();
        dropWinnersTable();
        dropClosedAuctionsTable();
    }

    public static void dropBidTable() throws UnknownHostException {
        getConnection().getCollection(Bid.class).drop();
    }

    public static void dropWinnersTable() throws UnknownHostException {
        getConnection().getCollection(AuctionWinner.class).drop();
    }

    public static void dropClosedAuctionsTable() throws UnknownHostException {
        getConnection().getCollection(ClosedAuction.class).drop();
    }
}
