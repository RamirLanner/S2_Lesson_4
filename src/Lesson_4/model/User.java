package Lesson_4.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class User {

    private static int counter;
    private final IntegerProperty ID;
    private StringProperty name;
    private Messages messageList;


    public User(String name) {
        counter++;
        ID = new SimpleIntegerProperty(counter);
        this.name = new SimpleStringProperty(name);
        messageList = new Messages();
    }

    public Messages getMessageList() {
        return messageList;
    }

    public void sendMsg(Message myMsg) {
        messageList.add(myMsg);
    }

    public IntegerProperty getID() {
        return ID;
    }

    public StringProperty getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }
}
