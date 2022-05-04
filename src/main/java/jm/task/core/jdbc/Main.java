package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Александр", "Александрович", (byte)25);
        userService.saveUser("Иван", "Иванович", (byte)15);
        userService.saveUser("Борис", "Борисович", (byte)35);
        userService.saveUser("Саша", "Сашович", (byte)14);

        System.out.println("\n");

        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
