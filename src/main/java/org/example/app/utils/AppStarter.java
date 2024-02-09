package org.example.app.utils;

import org.example.app.controller.AppController;
import org.example.app.model.AppModel;
import org.example.app.view.AppView;

public class AppStarter {

    public static void startApp() {

        AppModel model = new AppModel();
        AppView view = new AppView();
        AppController controller = new AppController(view, model);
        controller.runApp();
    }
}
