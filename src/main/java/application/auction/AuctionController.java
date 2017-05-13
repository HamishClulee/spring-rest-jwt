package application.auction;

import dao.AuctionDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by hamish on 10/05/17.
 */
@CrossOrigin
@RestController
public class AuctionController {

    @RequestMapping(value = "/auctions/{id}")
    public Auction auction(@PathVariable Integer id) throws UnknownHostException {
        Auction auction = AuctionDAO.getAuctionByID(id);
        return new Auction(auction.getId(), auction.getName(), auction.getShortDescription(), auction.getLongDescription(), auction.getImagePath(), auction.getAdditionalInformationLink(), auction.getReserve(), auction.getCurrentAmount(), auction.getStatus(), auction.getDateCreated());
    }

    @RequestMapping("/auctions")
    public List<Auction> getAll() throws UnknownHostException {
        List<Auction> auctions = AuctionDAO.getAllAuctions();
        return auctions;
    }
}
