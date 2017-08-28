package com.web;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.HelloContentFiller;

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
     *
     * @param name Name of the user.
     * @return returns a new String.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String greet(
        @RequestParam(value = "name", required = false, defaultValue = "Bob") final String name,
        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("content", fillContents());
        return "hello";
    }

    private String fillContents() {
        HelloContentFiller filler = new HelloContentFiller();
        return filler.provideContents();
    }
}
