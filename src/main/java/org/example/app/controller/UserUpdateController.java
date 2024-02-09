package org.example.app.controller;

import org.example.app.model.UserUpdateModel;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserUpdateView;

public class UserUpdateController {

    UserUpdateModel model;
    UserUpdateView view;

    public UserUpdateController(UserUpdateModel model, UserUpdateView view) {
        this.model = model;
        this.view = view;
    }

    public void updateUser() {
        view.getOutput(model.updateUser(view.getData()));
        AppStarter.startApp();
    }
}
