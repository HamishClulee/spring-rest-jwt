package application.auction;

import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * Created by hamish on 8/07/17.
 */
public class ClosedAuction {

    @Id
    private Integer id;
    private String name;
    private Integer reserve;
    private Date dateWon;

    public ClosedAuction() {

    }

    public ClosedAuction(Integer id, String name, Integer reserve, Date dateWon) {
        this.id = id;
        this.name = name;
        this.reserve = reserve;
        this.dateWon = dateWon;
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

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public Date getDateWon() {
        return dateWon;
    }

    public void setDateWon(Date dateWon) {
        this.dateWon = dateWon;
    }
}
