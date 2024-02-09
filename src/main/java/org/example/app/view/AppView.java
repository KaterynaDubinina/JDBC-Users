package org.example.app.view;

import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                
                \uD83D\uDDA5\uFE0F  Оберіть дію:
                 
                1\uFE0F\u20E3  Створити користувача
                2\uFE0F\u20E3  Переглянути користувачів
                3\uFE0F\u20E3  Оновити електрону адресу
                4\uFE0F\u20E3  Видалити користувача
                
                0\uFE0F\u20E3  Закрити додаток
                """);
    }

    public void getOutput(int choice, String output) {
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
