package application.bid;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by hamish on 2/07/17.
 */
public class Bid {

    @Id
    private String id;
    private Integer auctionId;
    private String userEmail;
    private String timeStamp;
    private Integer currentAmount;

    public Bid(){

    }

    public Bid(String id, Integer auctionId, String userEmail, String timeStamp, Integer currentAmount) {
        this.id = id;
        this.auctionId = auctionId;
        this.userEmail = userEmail;
        this.timeStamp = timeStamp;
        this.currentAmount = currentAmount;
    }

    public Integer getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Integer currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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
        if (userEmail != null ? !userEmail.equals(bid.userEmail) : bid.userEmail != null) return false;
        if (timeStamp != null ? !timeStamp.equals(bid.timeStamp) : bid.timeStamp != null) return false;
        return currentAmount != null ? currentAmount.equals(bid.currentAmount) : bid.currentAmount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (auctionId != null ? auctionId.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (currentAmount != null ? currentAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id='" + id + '\'' +
                ", auctionId=" + auctionId +
                ", userEmail='" + userEmail + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", currentAmount=" + currentAmount +
                '}';
    }
}
