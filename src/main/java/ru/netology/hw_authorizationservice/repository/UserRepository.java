package ru.netology.hw_authorizationservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw_authorizationservice.model.User;
import ru.netology.hw_authorizationservice.service.AuthorizationService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<String, User> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        users.put("Vladimir", new User("Vladimir", "qwerty",
                List.of(Authorities.READ,Authorities.DELETE,Authorities.WRITE)));
        users.put("Irina", new User("Irina", "12345",
                List.of(Authorities.READ,Authorities.WRITE)));
        users.put("Oleg", new User("Oleg", "qwerty",
                List.of(Authorities.READ)));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (users.containsKey(user) && users.get(user).getPassword().equals(password)) {
            return users.get(user).getAuthorities();

        } else return Collections.emptyList();


    }
}
