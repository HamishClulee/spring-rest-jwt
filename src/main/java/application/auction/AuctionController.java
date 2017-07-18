package application.auction;

import application.Bid.Bid;
import dao.AuctionDAO;
import dao.BidDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hamish on 10/05/17.
 */
@RestController
public class AuctionController {

    @CrossOrigin
    @RequestMapping(value = "/auctions/{id}")
    public Auction auction(@PathVariable Integer id) throws UnknownHostException {
        return AuctionDAO.getAuctionByID(id);
    }

    @CrossOrigin
    @RequestMapping("/auctions")
    public List<Auction> getAll() throws UnknownHostException {
        return AuctionDAO.getAllAuctions();
    }

    @CrossOrigin
    @RequestMapping("/auctionwinners")
    public List<AuctionWinner> getAllWinners() throws UnknownHostException {
        return AuctionDAO.getAllAuctionWinners();
    }

    @CrossOrigin
    @RequestMapping("/closedauctions")
    public List<ClosedAuction> getAllClosedAuctions() throws UnknownHostException {
        return AuctionDAO.getAllClosedAuctions();
    }

    @CrossOrigin
    @RequestMapping(value = "/restallbids/{auctionid}")
    public List<Bid> bidsByAuction(@PathVariable Integer auctionid) throws UnknownHostException {
        return BidDAO.allBidsByAuctionId(auctionid);
    }

    @CrossOrigin
    @RequestMapping(value = "/restallbids/{auctionid}/{email}")
    public List<Bid> getAllBidsByAuctionByUser(@PathVariable Integer auctionid, @PathVariable String email) throws UnknownHostException {
        return BidDAO.allBidsByAuctionIdAndUserId(auctionid, email);
    }

    @CrossOrigin
    @RequestMapping("/restallbids")
    public List<Bid> getAllBids() throws UnknownHostException {
        return BidDAO.getAllBids();
    }
}
