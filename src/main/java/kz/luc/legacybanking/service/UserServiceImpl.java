package kz.luc.legacybanking.service;

import kz.luc.legacybanking.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {
    private final List<User> users = new ArrayList<>();

    public void register(String username, String password) {
        users.add(new User(username, password));
    }

    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public List<User> getAllUsers() { return users; }

    public void deleteUser(long id) { users.removeIf(user -> user.getId() == id); }
}
