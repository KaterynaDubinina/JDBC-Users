package org.example.app.controller;

import org.example.app.model.UserCreateModel;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserCreateView;

public class UserCreateController {

    UserCreateView view;
    UserCreateModel model;

    public UserCreateController(UserCreateModel model, UserCreateView view) {
        this.model = model;
        this.view = view;
    }

    public void createUser() {
        view.getOutput(model.createUser(view.getData()));
        AppStarter.startApp();
    }
}
