package org.example.app.model;

import org.example.app.controller.UserCreateController;
import org.example.app.controller.UserDeleteController;
import org.example.app.controller.UserReadController;
import org.example.app.controller.UserUpdateController;
import org.example.app.exeptions.OptionException;
import org.example.app.repository.UserCreateRepository;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.repository.UserReadRepository;
import org.example.app.repository.UserUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UserCreateView;
import org.example.app.view.UserDeleteView;
import org.example.app.view.UserReadView;
import org.example.app.view.UserUpdateView;

public class AppModel {

    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateModel model = new UserCreateModel(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(model, view);
        controller.createUser();
    }

    public void readUser() {
        UserReadRepository repository = new  UserReadRepository();
        UserReadModel model = new  UserReadModel(repository);
        UserReadView view = new  UserReadView();
        UserReadController controller = new  UserReadController(model, view);
        controller.readUser();
    }

    public void updateUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateModel model = new UserUpdateModel(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(model, view);
        controller.updateUser();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteModel model = new UserDeleteModel(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(model, view);
        controller.deleteUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
