package application.bid;

import application.auction.Auction;
import application.mail.Mail;
import dao.AuctionDAO;
import dao.BidDAO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by hamish on 2/07/17.
 */
@RestController
public class BidController {

    @MessageMapping("/bid")
    @SendTo("/allBids/bidResponse")
    public BidResponse response(Bid bid) throws Exception {
        // increment currentAmount decrement user balance
        Auction auction = AuctionDAO.bidReturnAuction(bid.getAuctionId(), bid.getUserEmail());
        bid.setCurrentAmount(auction.getCurrentAmount());
        BidDAO.saveBid(bid);
        // determine if winner
        Boolean isWinningBid = auction.getCurrentAmount().equals(auction.getReserve());
        if(isWinningBid){
            AuctionDAO.winningBidRecieved(bid.getAuctionId());
            Mail mail = new Mail(bid.getUserEmail(), "You've just won an auction for " + auction.getName(), new Date(), "Lorem Ipsum bally wog reference carrots tell john hes a dingus", "winning bid");
        }

        return new BidResponse(auction.getCurrentAmount(), isWinningBid); // bids in last day bids in last hour etc
    }



}
