package Lesson_4.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Message {
    private StringProperty msg;

    public Message(String msg) {
        this.msg = new SimpleStringProperty(msg);
    }

    public StringProperty getMsgContent() {
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(msg, message.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
