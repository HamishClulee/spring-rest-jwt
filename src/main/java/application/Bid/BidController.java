package application.Bid;

import dao.AuctionDAO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by hamish on 2/07/17.
 */
@Controller
public class BidController {

    private Integer count = 0;

    @MessageMapping("/bid")
    @SendTo("/allBids/bidresponse")
    public BidResponse response(Bid bid) throws Exception {
        AuctionDAO.makeBid(bid.getAuctionId());
        count++;
        if(count % 10 == 0){
            System.out.println("Should fire every 10 ids's " + AuctionDAO.getAuctionByID(bid.getAuctionId()).getCurrentAmount().toString());
        }
        return new BidResponse("Bid ok, bid id: " + bid.getId() + "!");
    }
}
