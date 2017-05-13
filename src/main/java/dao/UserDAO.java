package dao;

import application.user.User;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;

/**
 * Created by hamish on 9/05/17.
 */
public class UserDAO extends MongoConnection{

    public static Datastore getConnection() throws UnknownHostException{
        morphia.map(User.class);
        return morphia.createDatastore(new MongoClient(uri), "dev");
    }

    public static List<User> getAllUsers() throws UnknownHostException {
        return getConnection().createQuery(User.class).asList();
    }

    public static void addNewUser(User user) throws UnknownHostException {
        getConnection().save(user);
    }

    public static User getUserByUserName(String username) throws UnknownHostException {
        return getConnection().get(User.class, username);
    }

    public static void deleteAllUsers() throws UnknownHostException{

        for(User user : getAllUsers()) {
            getConnection().delete(User.class, user.getUsername());
        }
    }



    public static void updateUserDetails(String userNameToBeUpdated, User updatedUser) throws UnknownHostException{
        Datastore ds = getConnection();
        ds.delete(User.class, userNameToBeUpdated);
        ds.save(updatedUser);
    }
}
