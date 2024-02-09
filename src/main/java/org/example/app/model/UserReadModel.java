package org.example.app.model;

import org.example.app.entity.User;
import org.example.app.repository.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadModel {

    UserReadRepository repository;

    public UserReadModel(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUser() {

        List<User> list = repository.readUser();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") ID: ")
                                .append(contact.getId())
                                .append(", ")
                                .append(contact.getName())
                                .append(", ")
                                .append(contact.getEmail())
                                .append("\n")
                );
                return "\n_________ Користувачі _________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
