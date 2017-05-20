package dbhelpers;

import application.auction.Auction;
import application.user.User;
import dao.AuctionDAO;
import dao.UserDAO;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * Created by hamish on 10/05/17.
 */
public class PopulateMongo {

    public static void main(String[] args) throws UnknownHostException {
        User user1 = new User("hamish@hamish.com", "Hamish", "Clulee", "123 Fake Street", new Date(), "hamish", "admin");
        User user2 = new User("james@james.com", "James", "Gooodman", "123 Fake Street", new Date(), "james", "admin");
        User user3 = new User("max@max.com", "Max", "TheMaddest", "123 Fake Street", new Date(), "max", "user");
        User user4 = new User("joe@joe.com", "Joe", "Cooper", "123 Fake Street", new Date(), "joe", "user");
        User user5 = new User("a", "test", "test", "123 Fake Street", new Date(), "a", "super-admin");


        UserDAO.deleteAllUsers();
        UserDAO.addNewUser(user1);
        UserDAO.addNewUser(user2);
        UserDAO.addNewUser(user3);
        UserDAO.addNewUser(user4);
        UserDAO.addNewUser(user5);


        Auction auction1 = new Auction(1, "Mean Television", "A really really mean television bro, this shit is da bomb", "A really really mean television bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 1, new Date());
        Auction auction2 = new Auction(2, "Mean Car", "A really really mean car bro, this shit is da bomb", "A really really mean television bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 1, new Date());
        Auction auction3 = new Auction(3, "Mean as Dog", "A really really mean dog bro, this shit is da bomb", "A really really mean television bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 2, new Date());
        Auction auction4 = new Auction(4, "Mean Sandwich", "A really really mean sandwich bro, this shit is da bomb", "A really really mean television bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 2, new Date());
        Auction auction5 = new Auction(5, "Mean Used Pencil", "A really really mean used pencil bro, this shit is da bomb", "A really really mean television bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 3, new Date());
        Auction auction6 = new Auction(6, "Mean as Toothbrush", "A really really mean toothbrush bro, this shit is da bomb", "A really really mean toothbrush bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 3, new Date());
        Auction auction7 = new Auction(7, "POLLING WORKS BRO", "A really really mean toothbrush bro, this shit is da bomb", "A really really mean toothbrush bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 1, new Date());
        Auction auction8 = new Auction(8, "Hey James, You're Cool", "A really really mean toothbrush bro, this shit is da bomb", "A really really mean toothbrush bro, this shit is da bomb", "/assets/tele.jpg", "https://google.com", 400, 100, 1, new Date());

        AuctionDAO.addNewAuction(auction1);
        AuctionDAO.addNewAuction(auction2);
        AuctionDAO.addNewAuction(auction3);
        AuctionDAO.addNewAuction(auction4);
        AuctionDAO.addNewAuction(auction5);
        AuctionDAO.addNewAuction(auction6);
        AuctionDAO.addNewAuction(auction7);
        AuctionDAO.addNewAuction(auction8);

        List<Auction> allAuctions = AuctionDAO.getAllAuctions();
        List<User> allUsers = UserDAO.getAllUsers();

        System.out.println("\n################# USER NAME DUMP ####################");
        for(User user : allUsers){
            System.out.println("Email --> " + user.getEmail());
        }

        System.out.println("\n############### AUCTION NAME DUMP ###################");
        for(Auction auction : allAuctions){
            System.out.println("Auction name --> " + auction.getName());
        }
    }
}
