package com.web.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Matyas_Perneky
 */
@Configuration
@ComponentScan({"services", "com.web.domain", "com.security.service"})
public class WebConfig {

}
