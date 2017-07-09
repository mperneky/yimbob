package com.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Yimbo on 2017.07.02..
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final String template = "Hello-Bello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody HelloBello greet(@RequestParam(value="name", required=false, defaultValue="Bob") String name) {
        return new HelloBello(counter.incrementAndGet(), String.format(template, name));
    }
}
