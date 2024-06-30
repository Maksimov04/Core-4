package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        this.userList = new ArrayList<>();
    }

    public void createUser(User user) {
        userList.add(user);
    }

    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(int userId, String newName, int newAge, String newEmail, String newAddress) {
        for (User user : userList) {
            if (user.getId() == userId) {
                user.setName(newName);
                user.setAge(newAge);
                user.setEmail(newEmail);
                user.setAdress(newAddress);
                break;
            }
        }
    }

    public void deleteUser(int userId) {
        userList.removeIf(user -> user.getId() == userId);
    }

    public void sortUsersByAddress() {
        Collections.sort(userList, Comparator.comparing(User::getAdress));
    }

    public void sortUsersByName() {
        Collections.sort(userList, Comparator.comparing(User::getName));
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.createUser(new User(1, "Илья", 25, "example@gmail.com", "Пенза"));
        userManager.createUser(new User(2, "Анна", 25, "anna@example.com", "Самара"));

        System.out.println("До сортировки по именам:");
        for (User user : userManager.userList) {
            System.out.println(user.getName() + " - " + user.getAdress());
        }

        userManager.sortUsersByName();

        System.out.println("\nПосле сортировки по именам:");
        for (User user : userManager.userList) {
            System.out.println(user.getName() + " - " + user.getAdress());
        }
    }
}


