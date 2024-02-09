package org.example.app.controller;

import org.example.app.model.UserDeleteModel;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserDeleteView;

public class UserDeleteController {

    UserDeleteModel model;
    UserDeleteView view;

    public UserDeleteController(UserDeleteModel model, UserDeleteView view) {
        this.model = model;
        this.view = view;
    }

    public void deleteUser() {
        view.getOutput(model.deleteUser(view.getData()));
        AppStarter.startApp();
    }
}
