package Lesson_4.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Messages {
    private LinkedList<Message> messages = new LinkedList<>();

    public void add(Message msg) {
        messages.addFirst(msg);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public ObservableList<Message> getAllData() {
        return FXCollections.observableArrayList(messages);
    }

    public Messages() {
        this.messages.addFirst(new Message(""));
    }
}
