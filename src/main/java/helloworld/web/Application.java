package helloworld.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * My first spring boot application.
 */
@SpringBootApplication
public class Application {

  /**
   * Starts the application.
   *
   * @param args arguments passed.
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
