package application.Bid;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by hamish on 2/07/17.
 */
public class Bid {

    @Id
    private String id;
    private Integer auctionId;
    private String userEmail;

    public Bid(){

    }

    public Bid (String id, Integer auctionId, String userEmail) {
        this.auctionId = auctionId;
        this.id = id;
        this.userEmail = userEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (id != null ? !id.equals(bid.id) : bid.id != null) return false;
        if (auctionId != null ? !auctionId.equals(bid.auctionId) : bid.auctionId != null) return false;
        return userEmail != null ? userEmail.equals(bid.userEmail) : bid.userEmail == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (auctionId != null ? auctionId.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }
}
