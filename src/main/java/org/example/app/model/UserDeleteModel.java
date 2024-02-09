package org.example.app.model;

import org.example.app.entity.User;
import org.example.app.exeptions.UpdateException;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteModel {

    UserDeleteRepository repository;

    public UserDeleteModel(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Перевірте введення", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("ID", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
