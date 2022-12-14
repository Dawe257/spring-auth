package com.dzhenetl.springauth.repository;

import com.dzhenetl.springauth.model.Authorities;
import com.dzhenetl.springauth.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = List.of(
                new User("Иван", "123"),
                new User("Петя", "456"
                ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return users.stream()
                .anyMatch(x -> x.getUsername().equals(user) && x.getPassword().equals(password)) ?
                List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE) :
                Collections.emptyList();
    }

}
