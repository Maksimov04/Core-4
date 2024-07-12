package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    List<User> users;
    private int nextUserId;

    public UserManager() {
        users = new ArrayList<>();
        nextUserId = 1;
    }

    public User createUser(String name, int age, String email, String address) {
        User newUser = new User(nextUserId, name, age, email, address);
        users.add(newUser);
        nextUserId++;
        return newUser;
    }

    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUser(int userId, String name, int age, String email, String address) {
        User user = getUserById(userId);
        if (user != null) {
            if (name != null) {
                user.setName(name);
            }
            if (age != 0) {
                user.setAge(age);
            }
            if (email != null) {
                user.setEmail(email);
            }
            if (address != null) {
                user.setAddress(address);
            }
            return true;
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public void sortUsersByAddress() {
        Collections.sort(users, Comparator.comparing(User::getAddress));
    }

    public void sortUsersByName() {
        Collections.sort(users, Comparator.comparing(User::getName));
    }

    public List<User> getUsers() {
        return users;
    }
}

