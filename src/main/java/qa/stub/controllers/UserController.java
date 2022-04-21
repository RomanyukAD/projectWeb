package qa.stub.controllers;

import entities.User;
import entities.UserDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
class UserController {
    private static Faker faker = new Faker();
    private Faker fakerRu = new Faker(new Locale("ru"));

    String firstName = fakerRu.name().firstName();
    String lastName = fakerRu.name().lastName();


    @GetMapping("/get/{id}")
    public UserDetail getUsers(@PathVariable Long id) {
        return new UserDetail(id, firstName + " " + lastName, "Студент", "Псковский филиал РАНХиГС", "Псков");
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        for (Integer i = 0; i < 300; i++) {
            list.add(new User(i.longValue(), firstName + " " + lastName + i, "Студент потока " + i));
        }
        return list;
    }
}