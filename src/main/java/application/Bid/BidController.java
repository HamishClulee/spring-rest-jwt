package application.Bid;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by hamish on 2/07/17.
 */
@Controller
public class BidController {

    @MessageMapping("/bid")
    @SendTo("/bidresponse")
    public BidResponse response(Bid bid) throws Exception {
        System.out.println("BID RECEIVED: ###################### :::: " + bid.getId());
        return new BidResponse("Bid ok, bid id: " + bid.getId() + "!");
    }
}
