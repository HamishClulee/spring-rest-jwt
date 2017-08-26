package application.bid;

import application.Mail.Mail;
import application.Mail.MailSummary;
import application.Utils.Utils;
import application.auction.Auction;
import com.sun.org.apache.xpath.internal.operations.Bool;
import dao.AuctionDAO;
import dao.BidDAO;
import dao.MailDAO;
import dao.UserDAO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

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
        Boolean isAuctionClosed = false;
        // deal with null pointer because the reserve has been met ands the auction has been closed and removed from the db
        if(auction == null) isAuctionClosed = true;
        bid.setCurrentAmount(auction.getCurrentAmount());
        bid.setAuctionName(auction.getName());
        BidDAO.saveBid(bid);
        // determine if winner
        Boolean isWinningBid = auction.getCurrentAmount().equals(auction.getReserve());
        // check user balance
        Boolean isOutOfBalance = UserDAO.isOuOfFunds(bid.getUserEmail());

        if(isOutOfBalance){
            MailSummary noFundsSummary = new MailSummary(new Date(), "You're out of funds!!", "You can top up your account by clicking here....", false, bid.getUserEmail());
            Mail noFundsMail = new Mail(Utils.generateMailId(), bid.getUserEmail(), noFundsSummary, "You've got no money left....ya muppet.... just top up your account and you're back up and at em...", false);
            MailDAO.saveMail(noFundsMail);
            return new BidResponse(auction.getCurrentAmount(), isWinningBid, isOutOfBalance, isAuctionClosed, noFundsSummary);
        }

        if(isWinningBid){
            AuctionDAO.winningBidRecieved(bid.getAuctionId());
            // create the Mail for the db and http calls and the summary for the websockets response
            MailSummary summary = new MailSummary(new Date(), "You've Won an Auction!!", "You won an auction for " + auction.getName(), false, bid.getUserEmail());
            Mail mail = new Mail(Utils.generateMailId(), bid.getUserEmail(), summary, "You've just won an auction. \nCongrats, we're getting your item ready to send to you right now...", false);
            // save mail to the db
            MailDAO.saveMail(mail);
            return new BidResponse(auction.getCurrentAmount(), isWinningBid, isOutOfBalance, isAuctionClosed, summary);
        }

        if(isWinningBid && isOutOfBalance) {
            AuctionDAO.winningBidRecieved(bid.getAuctionId());
            // create the Mail for the db and http calls and the summary for the websockets response
            MailSummary summary = new MailSummary(new Date(), "You've Won an Auction!! Also...", "You won an auction for " + auction.getName(), false, bid.getUserEmail());
            Mail mail = new Mail(Utils.generateMailId(), bid.getUserEmail(), summary, "You've just won an auction. \nCongrats, we're getting your item ready to send to you right now...You've also run out ofd funds in your account, you can top up by going to the account page.", false);
            // save mail to the db
            MailDAO.saveMail(mail);
            return new BidResponse(auction.getCurrentAmount(), isWinningBid, isOutOfBalance, isAuctionClosed, summary);
        }

        return new BidResponse(auction.getCurrentAmount(), isWinningBid, isOutOfBalance, isAuctionClosed, null); // bids in last day bids in last hour etc
    }



}
