package Lesson_4.controller;

import Lesson_4.Main;
import Lesson_4.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class UserOverviewController {

    private Main mainApp;

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> myUserColumn;

    @FXML
    private TableView<Message> messageTable;
    @FXML
    private TableColumn<Message, String> myMessageColumn;

    @FXML
    private TextArea msgBox;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        userTable.setItems(mainApp.getPersonData());
    }

    /*Инициализация*/
    @FXML
    public void initialize() {
        //тут я задаю обработчик события нажатия Enter если активно поле TextArea
        //Вообще я бы не хотел бы его добавлять, т.к. Enter позволял переходить на другую строку
        //Но пока так нормально
        msgBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSendMessage();
            }
        });
        //список собеседников
        myUserColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        //если выделен собеседник отображается чат
        userTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //событие на выделение ячейки
            showMessages(newValue);
        });
    }

    /*оображение переписки*/
    @FXML
    public void showMessages(User user) {
        messageTable.setItems(user.getMessageList().getAllData());
        myMessageColumn.setCellValueFactory(cellData -> cellData.getValue().getMsgContent());
    }

    /*обработка события нажатия кнопки Send*/
    @FXML
    private void handleSendMessage() {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            selectedUser.sendMsg(new Message(msgBox.getText()));
            msgBox.clear();
            showMessages(selectedUser);
        } else {
            showNoSelectionAlert();
        }
    }

    /*окно предупреждение, если не выделен собеседник и программа не знает кому отправить сообщение*/
    private void showNoSelectionAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("User, not selected!");
        alert.setContentText("Please select a user in the left table");
        alert.showAndWait();
    }

}
