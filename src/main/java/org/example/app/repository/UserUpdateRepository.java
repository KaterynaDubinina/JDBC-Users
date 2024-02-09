package org.example.app.repository;

import org.example.app.database.UsersDataBase;
import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateRepository {

    public String updateUser(User user) {
        if (IdChecker.isIdExists(user.getId())) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateUserById(User user) {

        String sql = "UPDATE " + Constants.TABLE_USERS + " SET email = ? WHERE id = ?";
        try (PreparedStatement pstmt = UsersDataBase.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
            return Constants.DATA_UPDATE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
