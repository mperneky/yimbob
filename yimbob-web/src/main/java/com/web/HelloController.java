package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import services.ContentProvider;

/**
 * Hello controller of my application.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    ContentProvider filler;

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
        filler.provideContents();
        return null;
    }
}
