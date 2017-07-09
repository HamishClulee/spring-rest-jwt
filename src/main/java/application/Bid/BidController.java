package application.Bid;

import application.auction.Auction;
import dao.AuctionDAO;
import dao.BidDAO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by hamish on 2/07/17.
 */
@Controller
public class BidController {

    @MessageMapping("/bid")
    @SendTo("/allBids/bidResponse")
    public BidResponse response(Bid bid) throws Exception {
        BidDAO.saveBid(bid);
        // increment currentAmount decrement user balance
        Auction auction = AuctionDAO.bidReturnAuction(bid.getAuctionId(), bid.getUserEmail());
        // determine if winner
        Boolean isWinningBid = auction.getCurrentAmount().equals(auction.getReserve());
        if(isWinningBid) AuctionDAO.winningBidRecieved(bid.getAuctionId());
        // Thread.sleep(5000);
        return new BidResponse(auction.getCurrentAmount(), isWinningBid);
    }
}
