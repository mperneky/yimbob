package helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Yimbo on 2017.07.02..
 */

/**
 * Hello controller of my application.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final String template = "Hello-Bello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Greets the user with the given or default parameters.
     * @param name Name of the user.
     * @return returns a new {@link HelloBello} object.
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody HelloBello greet(@RequestParam(value = "name", required = false, defaultValue = "Bob") final String name) {
        return new HelloBello(counter.incrementAndGet(), String.format(template, name));
    }
}
