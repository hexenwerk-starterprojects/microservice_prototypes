package cz.hexenwerk.sandbox.microservice.crud.view.login;

import cz.hexenwerk.sandbox.microservice.crud.view.main.MainPane;
import cz.hexenwerk.sandbox.microservice.crud.view.StageManager;
import cz.hexenwerk.sandbox.microservice.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginPaneManager
{
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    public void login(LoginPane loginPane)
    {
        String username = loginPane.getUsername();
        String password = loginPane.getPassword();

        if (userService.authenticate(username, password))
            stageManager.rebuildStage(MainPane.class);
        else
            loginPane.getLblLogin().setText("Login Failed.");
    }
}
