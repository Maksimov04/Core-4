package task;

import java.util.Scanner;

public class Main {

    private static UserManager userManager;
    private static UserInfoFileManager fileManager;

    public static void main(String[] args) {
        userManager = new UserManager();
        fileManager = new UserInfoFileManager("users.txt");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    getUserById(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    sortUsersByAddress();
                    break;
                case 6:
                    sortUsersByName();
                    break;
                case 7:
                    saveUsersToFile();
                    break;
                case 8:
                    loadUsersFromFile();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите пункт из меню.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Создать пользователя");
        System.out.println("2. Получить пользователя по ID");
        System.out.println("3. Обновить пользователя");
        System.out.println("4. Удалить пользователя");
        System.out.println("5. Сортировать пользователей по адресу");
        System.out.println("6. Сортировать пользователей по имени");
        System.out.println("7. Сохранить пользователей в файл");
        System.out.println("8. Загрузить пользователей из файла");
        System.out.println("0. Выход");
        System.out.print("Введите ваш выбор: ");
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст пользователя: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите email пользователя: ");
        String email = scanner.nextLine();
        System.out.print("Введите адрес пользователя: ");
        String address = scanner.nextLine();

        User newUser = userManager.createUser(name, age, email, address);
        System.out.println("Пользователь создан: " + newUser);
    }

    private static void getUserById(Scanner scanner) {
        System.out.print("Введите ID пользователя: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = userManager.getUserById(userId);
        if (user != null) {
            System.out.println("Информация о пользователе: " + user);
        } else {
            System.out.println("Пользователь с таким ID не найден.");
        }
    }

    private static void updateUser(Scanner scanner) {
        System.out.print("Введите ID пользователя: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите новое имя (пустое для пропуска): ");
        String newName = scanner.nextLine();
        System.out.print("Введите новый возраст (0 для пропуска): ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите новый email (пустое для пропуска): ");
        String newEmail = scanner.nextLine();
        System.out.print("Введите новый адрес (пустое для пропуска): ");
        String newAddress = scanner.nextLine();

        boolean success = userManager.updateUser(userId, newName, newAge, newEmail, newAddress);
        if (success) {
            System.out.println("Пользователь обновлен.");
        } else {
            System.out.println("Пользователь с таким ID не найден.");
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Введите ID пользователя: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        boolean success = userManager.deleteUser(userId);
        if (success) {
            System.out.println("Пользователь удален.");
        } else {
            System.out.println("Пользователь с таким ID не найден.");
        }
    }

    private static void sortUsersByAddress() {
        userManager.sortUsersByAddress();
        System.out.println("Список пользователей, отсортированный по адресу:");
        for (User user : userManager.getUsers()) {
            System.out.println(user);
        }
    }

    private static void sortUsersByName() {
        userManager.sortUsersByName();
        System.out.println("Список пользователей, отсортированный по имени:");
        for (User user : userManager.getUsers()) {
            System.out.println(user);
        }
    }

    private static void saveUsersToFile() {
        fileManager.saveUsersToFile(userManager.getUsers());
        System.out.println("Пользователи сохранены в файл.");
    }

    private static void loadUsersFromFile() {
        userManager.users = fileManager.loadUsersFromFile();
        System.out.println("Пользователи загружены из файла.");
    }
}

