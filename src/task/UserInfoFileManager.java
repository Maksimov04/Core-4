package task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserInfoFileManager {
    public void createUserInfoFile(String username, String email, String password) {
        try {
            FileWriter fileWriter = new FileWriter("File.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Username: " + username);
            printWriter.println("Email: " + email);
            printWriter.println("Password: " + password);

            printWriter.close();
            System.out.println("Файл с информацией о пользователе успешно создан.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при создании файла информации о пользователе.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserInfoFileManager userInfoFileManager = new UserInfoFileManager();
        userInfoFileManager.createUserInfoFile("john_doe", "johndoe@email.com", "password123");
    }
}


