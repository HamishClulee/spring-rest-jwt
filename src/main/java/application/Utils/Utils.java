package application.Utils;

import java.util.UUID;

/**
 * Created by hamish on 31/07/17.
 */
public class Utils {

    public static String generateMailId(){
        return UUID.randomUUID().toString();
    }
}
