package Lesson_4.repository;

import Lesson_4.model.Message;
import Lesson_4.model.User;
import Lesson_4.model.UserList;


//заглушка на получение данных из хранилища
public class MyRepo {
    public static void creatMyData(UserList users){
        User user1 = new User("Ivan");
        User user2 = new User("Petr");
        User user3 = new User("Alex");
        users.addUser(user1,user2,user3);
        Message msg = new Message("Привет, как дела!\n Азаза!!");
        user1.sendMsg(msg);
    }
}
