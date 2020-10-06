package Lesson_4;

import Lesson_4.controller.UserOverviewController;
import Lesson_4.model.Message;
import Lesson_4.model.User;
import Lesson_4.model.UserList;
import Lesson_4.repository.MyRepo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Arrays;

public class Main extends Application {

    UserList myUsers = new UserList();
    private Stage primaryStage;
    private ObservableList<User> userData;

    public Main(){
        MyRepo.creatMyData(myUsers);
        this.userData = FXCollections.observableArrayList(myUsers.getAllData());
    }

    public ObservableList<User> getPersonData() {
        return userData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/ChatDialog.fxml"));
        Parent root =loader.load();

        //позаимствовал часть функционала, думал делать несколько окон и переключаться, по аналогии с примером
        //пока не пригодилось

        UserOverviewController controller = loader.getController();
        controller.setMainApp(this);

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MyChat");
        primaryStage.setScene(new Scene(root));//, 300, 275

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public Window getPrimaryStage() {
        return primaryStage;
    }

}
