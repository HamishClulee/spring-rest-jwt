package application.bid;

import application.auction.Auction;
import dao.AuctionDAO;
import dao.BidDAO;
import dao.UserDAO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by hamish on 2/07/17.
 */
@Controller
public class BidController {

    @MessageMapping("/bid")
    @SendTo("/bids/bidResponse")
    public BidResponse response(Bid bid) throws Exception {
        // increment currentAmount decrement user balance
        Auction auction = AuctionDAO.bidReturnAuction(bid.getAuctionId(), bid.getUserEmail());
        bid.setCurrentAmount(auction.getCurrentAmount());
        BidDAO.saveBid(bid);
        // determine if winner
        Boolean isWinningBid = auction.getCurrentAmount().equals(auction.getReserve());
        // check user balance
        Boolean isOutOfBalance = UserDAO.isOuOfFunds(bid.getUserEmail());
        if(isWinningBid){
            AuctionDAO.winningBidRecieved(bid.getAuctionId());
        }
        return new BidResponse(auction.getCurrentAmount(), isWinningBid, isOutOfBalance); // bids in last day bids in last hour etc
    }



}
