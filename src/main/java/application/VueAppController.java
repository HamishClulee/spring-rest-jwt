package application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by hamish on 3/07/17.
 */
@Controller
public class VueAppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Map<String, Object> model) {
        return "/resources/index.html";
    }

}
