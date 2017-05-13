package application.user;

import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hamish on 9/05/17.
 */
public class User {

    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private Date dateCreated;
    private String password;

    public User(){

    }

    public User(String username, String firstName, String lastName, String address, Date dateCreated, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateCreated = dateCreated;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
