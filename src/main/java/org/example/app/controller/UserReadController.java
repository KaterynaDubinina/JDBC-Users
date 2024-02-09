package org.example.app.controller;

import org.example.app.model.UserReadModel;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserReadView;

public class UserReadController {

    UserReadModel model;
    UserReadView view;

    public UserReadController(UserReadModel model, UserReadView view) {
        this.model = model;
        this.view = view;
    }

    public void readUser() {
        view.getOutput(model.readUser());
        AppStarter.startApp();
    }
}
