package task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoFileManager {
    private String filePath;

    public UserInfoFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveUsersToFile(List<User> users) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (User user : users) {
                writer.println(user.getId() + "," + user.getName() + "," + user.getAge() + "," + user.getEmail() + "," + user.getAddress());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public List<User> loadUsersFromFile() {
        List<User> loadedUsers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String email = parts[3];
                String address = parts[4];
                loadedUsers.add(new User(id, name, age, email, address));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
        }
        return loadedUsers;
    }
}








