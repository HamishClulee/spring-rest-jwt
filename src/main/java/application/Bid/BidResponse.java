package application.Bid;

/**
 * Created by hamish on 2/07/17.
 */
public class BidResponse {

    private String status;

    public BidResponse (String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
