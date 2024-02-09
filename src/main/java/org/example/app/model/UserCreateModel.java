package org.example.app.model;

import org.example.app.entity.User;
import org.example.app.exeptions.CreateException;
import org.example.app.repository.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateModel {

    UserCreateRepository repository;

    public UserCreateModel(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Перевірте введення", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setName(data[0]);
        user.setEmail(data[1]);
        return user;
    }
}
