package org.example.app.model;

import org.example.app.entity.User;
import org.example.app.exeptions.UpdateException;
import org.example.app.repository.UserUpdateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;
import org.example.app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserUpdateModel {

    UserUpdateRepository repository;

    public UserUpdateModel(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Перевірте введення", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setEmail(data[1]);
        return user;
    }
}
