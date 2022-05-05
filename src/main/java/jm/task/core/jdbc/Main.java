package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = Arrays.asList(
                new User("Александр", "Александрович", (byte) 25),
                new User("Иван", "Иванович", (byte) 15),
                new User("Борис", "Борисович", (byte) 35),
                new User("Саша", "Сашович", (byte) 14)
        );
        userService.createUsersTable();
        users.forEach(userService);

        System.out.println("\n");

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
