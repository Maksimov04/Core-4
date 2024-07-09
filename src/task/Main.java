package task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInfoFileManager userInfoFileManager = new UserInfoFileManager();
        userInfoFileManager.createUserInfoFile("Иван", "pandas1987@mail.ru","1233111");

        System.out.println("Добро пожаловать в систему управления пользователями.");

        boolean running = true;
        while (running) {
            System.out.println("Введите команду: создать, получить, обновить, удалить, перечислить или выйти.");
            String command = scanner.nextLine();

            switch (command) {
                case "create":
                    System.out.println("Введите имя пользователя:");
                    String newUser = scanner.nextLine();
                    users.add(newUser);
                    System.out.println("Пользователь успешно создан");
                    break;
                case "get":
                    System.out.println("Введите индекс пользователя:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index < users.size()) {
                        System.out.println("User " + index + ": " + users.get(index));
                    } else {
                        System.out.println("Пользователь не найден");
                    }
                    break;
                case "update":
                    System.out.println("Введите индекс пользователя для обновления:");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (updateIndex < users.size()) {
                        System.out.println("Введите новое имя пользователя:");
                        String updatedUser = scanner.nextLine();
                        users.set(updateIndex, updatedUser);
                        System.out.println("Пользователь обновлен успешно");
                    } else {
                        System.out.println("Пользователь не найден");
                    }
                    break;
                case "delete":
                    System.out.println("Введите индекс пользователя, которого требуется удалить:");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (deleteIndex < users.size()) {
                        users.remove(deleteIndex);
                        System.out.println("Пользователь успешно удален");
                    } else {
                        System.out.println("Пользователь не найден");
                    }
                    break;
                case "list":
                    System.out.println("Список пользователей:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println("User " + i + ": " + users.get(i));
                    }
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда. Пожалуйста, попробуйте еще разю");
            }
        }

        System.out.println("Благодарим вас за использование системы управления пользователями");

    }
}
