package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.List;
import java.util.function.Consumer;

public class UserServiceImpl implements UserService, Consumer<User> {

    private UserDaoJDBCImpl context;
    public UserServiceImpl() {
        context = new UserDaoJDBCImpl();
    }

    public void createUsersTable() throws SQLException {
        context.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        context.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        context.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        context.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return context.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        context.cleanUsersTable();
    }

    @Override
    public void accept(User user) {
        try {
            context.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем – %s добавлен в базу данных\n", user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
