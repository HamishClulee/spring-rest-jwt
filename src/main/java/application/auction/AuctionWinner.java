package application.auction;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by hamish on 8/07/17.
 */
public class AuctionWinner {

    @Id
    private Integer auctionId;
    private String winnerEmail;

    public AuctionWinner(){

    }

    public AuctionWinner(Integer auctionId, String winnerEmail) {
        this.auctionId = auctionId;
        this.winnerEmail = winnerEmail;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getWinnerEmail() {
        return winnerEmail;
    }

    public void setWinnerEmail(String winnerEmail) {
        this.winnerEmail = winnerEmail;
    }
}
