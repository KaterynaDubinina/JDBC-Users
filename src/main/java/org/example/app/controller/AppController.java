package org.example.app.controller;

import org.example.app.model.AppModel;
import org.example.app.utils.Constants;
import org.example.app.view.AppView;

public class AppController {

    AppView view;
    AppModel model;

    public AppController(AppView view, AppModel model) {
        this.view = view;
        this.model = model;
    }

    public void runApp() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> model.createUser();
            case 2 -> model.readUser();
            case 3 -> model.updateUser();
            case 4 -> model.deleteUser();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> model.getNoSuchOption(choice);
        }
    }
}
