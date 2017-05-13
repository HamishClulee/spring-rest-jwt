package dao;

import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Morphia;

/**
 * Created by hamish on 9/05/17.
 */
abstract class MongoConnection {
    protected static final MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/");
    protected static final Morphia morphia = new Morphia();
}
