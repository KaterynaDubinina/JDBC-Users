package org.example.app.repository;

import org.example.app.database.UsersDataBase;
import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteRepository {

    public String deleteUser(User user) {
        if (IdChecker.isIdExists(user.getId())) {
            return deleteUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String deleteUserById(User user) {

        String sql = "DELETE FROM " + Constants.TABLE_USERS + " WHERE id = ?";

        try (PreparedStatement stmt = UsersDataBase.connect().prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            return Constants.DATA_DELETE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
