package cz.hexenwerk.sandbox.microservice.crud.view.main;

import cz.hexenwerk.sandbox.microservice.crud.view.FxController;
import cz.hexenwerk.sandbox.microservice.crud.view.StageManager;
import cz.hexenwerk.sandbox.microservice.crud.view.main.center.UserListPane;
import cz.hexenwerk.sandbox.microservice.crud.view.main.left.UserDetailPane;
import cz.hexenwerk.sandbox.microservice.crud.view.main.top.MenuBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class MainPane implements Initializable, FxController
{
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    public BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // set layout
        borderPane.setTop(stageManager.loadView(MenuBar.class));
        borderPane.setLeft(stageManager.loadView(UserDetailPane.class));
        borderPane.setCenter(stageManager.loadView(UserListPane.class));
    }
}
