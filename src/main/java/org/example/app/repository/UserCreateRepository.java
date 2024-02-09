package org.example.app.repository;

import org.example.app.database.UsersDataBase;
import org.example.app.entity.User;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCreateRepository {

    public String createUser(User user) {

        String sql = "INSERT INTO " + Constants.TABLE_USERS +
                " (name, email) VALUES(?, ?)";

        try (PreparedStatement pstmt = UsersDataBase.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
