package com.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.web.domain.ContentFiller;
import objects.QuestionsResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.ContentProvider;

/**
 * Hello controller of my application.
 */
@Controller
@Service
@RequestMapping("/hello")
public class HelloController {

    private QuestionsResponseObject responseObject;

    @Autowired
    ContentProvider contentProvider;

    @Autowired
    ContentFiller contentFiller;

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
        setResponseObject(name);
        model.addAttribute("name", responseObject.getRequestor());
        model.addAttribute("content", contentFiller.getPageContents(responseObject));
        model.addAttribute("reqID", responseObject.getId());
        return "hello";
    }

    private void setResponseObject(String name) {
        responseObject = contentProvider.provideContents(name);
    }
}
