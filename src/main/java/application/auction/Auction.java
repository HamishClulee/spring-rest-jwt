package application.auction;


import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * Created by hamish on 9/05/17.
 */
public class Auction {

    @Id
    private Integer id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String imagePath;
    private String additionalInformationLink;
    private Integer reserve;
    private Integer currentAmount;
    private Integer status;
    private Date dateCreated;

    public Auction() {
    }

    public Auction(Integer id, String name, String shortDescription, String longDescription, String imagePath, String additionalInformationLink, Integer reserve, Integer currentAmount, Integer status, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imagePath = imagePath;
        this.additionalInformationLink = additionalInformationLink;
        this.reserve = reserve;
        this.currentAmount = currentAmount;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAdditionalInformationLink() {
        return additionalInformationLink;
    }

    public void setAdditionalInformationLink(String additionalInformationLink) {
        this.additionalInformationLink = additionalInformationLink;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public Integer getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Integer currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;

        if (id != null ? !id.equals(auction.id) : auction.id != null) return false;
        if (name != null ? !name.equals(auction.name) : auction.name != null) return false;
        if (shortDescription != null ? !shortDescription.equals(auction.shortDescription) : auction.shortDescription != null)
            return false;
        if (longDescription != null ? !longDescription.equals(auction.longDescription) : auction.longDescription != null)
            return false;
        if (imagePath != null ? !imagePath.equals(auction.imagePath) : auction.imagePath != null) return false;
        if (additionalInformationLink != null ? !additionalInformationLink.equals(auction.additionalInformationLink) : auction.additionalInformationLink != null)
            return false;
        if (reserve != null ? !reserve.equals(auction.reserve) : auction.reserve != null) return false;
        if (currentAmount != null ? !currentAmount.equals(auction.currentAmount) : auction.currentAmount != null)
            return false;
        if (status != null ? !status.equals(auction.status) : auction.status != null) return false;
        return dateCreated != null ? dateCreated.equals(auction.dateCreated) : auction.dateCreated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (additionalInformationLink != null ? additionalInformationLink.hashCode() : 0);
        result = 31 * result + (reserve != null ? reserve.hashCode() : 0);
        result = 31 * result + (currentAmount != null ? currentAmount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", additionalInformationLink='" + additionalInformationLink + '\'' +
                ", reserve=" + reserve +
                ", currentAmount=" + currentAmount +
                ", status=" + status +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
