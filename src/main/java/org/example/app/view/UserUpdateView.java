package org.example.app.view;

import java.util.Scanner;

public class UserUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Введіть ID користувача: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Введіть оновлену електронну пошту у форматі example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{id, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
