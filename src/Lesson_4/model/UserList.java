package Lesson_4.model;

import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList {

    private Map<IntegerProperty, User> userList = new HashMap<>();

    public void addUser(User... users) {
        for (User user : users) {
            userList.put(user.getID(), user);
        }

    }

    public User getUser(int userID) {
        //метод не доделан, доберусь в дальнейшем
        return userList.get(userID);
    }

    public ArrayList<User> getAllData() {
        return new ArrayList<>(userList.values());
    }

}
