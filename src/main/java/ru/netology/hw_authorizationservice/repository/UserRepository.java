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
    private ConcurrentHashMap<String, ConcurrentHashMap<String, List<Authorities>>> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
//        users.put("Vladimir", new ConcurrentHashMap<>());
//        users.get("Vladimir").put("qwerty", Arrays.asList(Authorities.WRITE, Authorities.DELETE,Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        if (users.containsKey(user) && users.get(user).containsKey(password)) {
            return users.get(user).get(password);

        } else return Collections.emptyList();


    }
}
