package application.Bid;

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

    private Integer count = 0;

    @MessageMapping("/bid")
    @SendTo("/allBids/bidresponse")
    public BidResponse response(Bid bid) throws Exception {
        AuctionDAO.makeBid(bid.getAuctionId());
        BidDAO.saveBid(bid);
        return new BidResponse(bid.getId());
    }
}
