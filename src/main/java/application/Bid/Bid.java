package application.Bid;

/**
 * Created by hamish on 2/07/17.
 */
public class Bid {

    private String id;
    private Integer auctionId;

    public Bid(){

    }

    public Bid (String id, Integer auctionId) {
        this.auctionId = auctionId;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }
}
