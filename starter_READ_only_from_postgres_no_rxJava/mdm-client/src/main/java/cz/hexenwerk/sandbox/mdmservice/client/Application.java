package cz.hexenwerk.sandbox.mdmservice.client;

import cz.hexenwerk.sandbox.mdmservice.client.javfx.JavaFxClientApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class Application {

  public static void main(String[] args) {

    javafx.application.Application.launch(JavaFxClientApplication.class, args);

  }

}
