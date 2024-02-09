package org.example.app.repository;

import org.example.app.database.UsersDataBase;
import org.example.app.entity.User;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserReadRepository {

    List<User> list;

    public List<User> readUser() {

        try (Statement stmt = UsersDataBase.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name, email FROM " + Constants.TABLE_USERS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email")
                        )
                );
            }
            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
