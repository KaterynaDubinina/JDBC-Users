package org.example.app.view;

import java.util.Scanner;

public class UserCreateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Ведіть ім'я: ";
        System.out.print(title);
        String name = scanner.nextLine().trim();

        title = "Введіть електронну пошту у форматі example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{name, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
