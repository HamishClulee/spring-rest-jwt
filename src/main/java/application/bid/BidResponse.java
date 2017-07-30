package application.bid;

/**
 * Created by hamish on 2/07/17.
 */
public class BidResponse {

    private Integer updatedCurrentAmount;
    private Boolean winner;
    private Boolean isOutOfFunds;

    public BidResponse (final Integer updatedCurrentAmount, final Boolean winner, final Boolean isOutOfFunds){
        this.updatedCurrentAmount = updatedCurrentAmount;
        this.winner = winner;
        this.isOutOfFunds = isOutOfFunds;
    }

    public Boolean getOutOfFunds() {
        return isOutOfFunds;
    }

    public void setOutOfFunds(Boolean outOfFunds) {
        isOutOfFunds = outOfFunds;
    }

    public Integer getUpdatedCurrentAmount() {
        return updatedCurrentAmount;
    }

    public void setUpdatedCurrentAmount(Integer updatedCurrentAmount) {
        this.updatedCurrentAmount = updatedCurrentAmount;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BidResponse that = (BidResponse) o;

        if (updatedCurrentAmount != null ? !updatedCurrentAmount.equals(that.updatedCurrentAmount) : that.updatedCurrentAmount != null)
            return false;
        if (winner != null ? !winner.equals(that.winner) : that.winner != null) return false;
        return isOutOfFunds != null ? isOutOfFunds.equals(that.isOutOfFunds) : that.isOutOfFunds == null;
    }

    @Override
    public int hashCode() {
        int result = updatedCurrentAmount != null ? updatedCurrentAmount.hashCode() : 0;
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (isOutOfFunds != null ? isOutOfFunds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BidResponse{" +
                "updatedCurrentAmount=" + updatedCurrentAmount +
                ", winner=" + winner +
                ", isOutOfFunds=" + isOutOfFunds +
                '}';
    }
}
