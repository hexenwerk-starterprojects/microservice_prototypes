package cz.hexenwerk.sandbox.microservice.crud.view.main.center;

import cz.hexenwerk.sandbox.microservice.crud.model.User;
import cz.hexenwerk.sandbox.microservice.crud.view.StageManager;
import cz.hexenwerk.sandbox.microservice.crud.view.login.LoginPane;
import cz.hexenwerk.sandbox.microservice.crud.view.main.left.UserDetailPaneManager;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class UserListPane implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private UserListPaneManager userListPaneManager;

    @Autowired
    private UserDetailPaneManager userDetailPaneManager;

    final ObservableList<User> userList = FXCollections.observableArrayList();

    @FXML
    public Button btnRefresh;

    @FXML
    Button btnLogout;

    @FXML
    public
    TableView<User> userTable;

    @FXML
    private TableColumn<User, Long> colUserId;
    @FXML
    private TableColumn<User, String> colFirstName;
    @FXML
    private TableColumn<User, String> colLastName;
    @FXML
    private TableColumn<User, LocalDate> colDOB;
    @FXML
    private TableColumn<User, String> colGender;
    @FXML
    private TableColumn<User, String> colRole;
    @FXML
    private TableColumn<User, String> colEmail;
    @FXML
    private TableColumn<User, Boolean> colEdit;

    @FXML
    private MenuItem deleteUsers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // refresh table content if CTRL+R is pressed
        JavaFxObservable.actionEventsOf(btnRefresh)
                .subscribe(userListPaneManager.getRefreshRequests());

        JavaFxObservable.eventsOf(userTable, KeyEvent.KEY_PRESSED)
                .filter(ke -> ke.isControlDown() && ke.getCode().equals(KeyCode.R))
                .map(ke -> new ActionEvent())
                .subscribe(userListPaneManager.getRefreshRequests());

        // set column properties
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEdit.setCellFactory(new TableColumnTableCellCallback());

        // Add all users into table
        userListPaneManager.loadUserDetails();

        btnLogout.setOnAction(event -> stageManager.rebuildStage(LoginPane.class));
        deleteUsers.setOnAction(event -> userListPaneManager.deleteUsers());

        // set layout
    }

    private class TableColumnTableCellCallback implements Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>> {
        @Override
        public TableCell<User, Boolean> call(final TableColumn<User, Boolean> param) {
            return new TableCell<>() {
                final Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
                final Button btnEdit = new Button();

                @Override
                public void updateItem(Boolean check, boolean empty) {
                    super.updateItem(check, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btnEdit.setOnAction(e -> userDetailPaneManager.refreshUserPane(getTableView().getItems().get(getIndex())));

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv = new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        btnEdit.setGraphic(iv);

                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }
            };
        }
    }

}
