package application.bid;

import application.Mail.MailSummary;

/**
 * Created by hamish on 2/07/17.
 */
public class BidResponse {

    private Integer updatedCurrentAmount;
    private Boolean winner;
    private Boolean isOutOfFunds;
    private Boolean isAuctionClosed;
    private MailSummary mailSummary;

    public BidResponse (final Integer updatedCurrentAmount, final Boolean winner, final Boolean isOutOfFunds, final Boolean isAuctionClosed){
        this.updatedCurrentAmount = updatedCurrentAmount;
        this.winner = winner;
        this.isOutOfFunds = isOutOfFunds;
        this.isAuctionClosed = isAuctionClosed;
    }

    public BidResponse (final Integer updatedCurrentAmount, final Boolean winner, final Boolean isOutOfFunds, final Boolean isAuctionClosed, final MailSummary mailSummary){
        this.updatedCurrentAmount = updatedCurrentAmount;
        this.winner = winner;
        this.isOutOfFunds = isOutOfFunds;
        this.isAuctionClosed = isAuctionClosed;
        this.mailSummary = mailSummary;
    }

    public Boolean getAuctionClosed() {
        return isAuctionClosed;
    }

    public void setAuctionClosed(Boolean auctionClosed) {
        isAuctionClosed = auctionClosed;
    }

    public MailSummary getMailSummary() {
        return mailSummary;
    }

    public void setMailSummary(MailSummary mailSummary) {
        this.mailSummary = mailSummary;
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
        if (isOutOfFunds != null ? !isOutOfFunds.equals(that.isOutOfFunds) : that.isOutOfFunds != null) return false;
        if (isAuctionClosed != null ? !isAuctionClosed.equals(that.isAuctionClosed) : that.isAuctionClosed != null)
            return false;
        return mailSummary != null ? mailSummary.equals(that.mailSummary) : that.mailSummary == null;
    }

    @Override
    public int hashCode() {
        int result = updatedCurrentAmount != null ? updatedCurrentAmount.hashCode() : 0;
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (isOutOfFunds != null ? isOutOfFunds.hashCode() : 0);
        result = 31 * result + (isAuctionClosed != null ? isAuctionClosed.hashCode() : 0);
        result = 31 * result + (mailSummary != null ? mailSummary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BidResponse{" +
                "updatedCurrentAmount=" + updatedCurrentAmount +
                ", winner=" + winner +
                ", isOutOfFunds=" + isOutOfFunds +
                ", isAuctionClosed=" + isAuctionClosed +
                ", mailSummary=" + mailSummary +
                '}';
    }
}
