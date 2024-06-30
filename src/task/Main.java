package task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the User Management System");

        boolean running = true;
        while (running) {
            System.out.println("Enter a command: create, get, update, delete, list or exit");
            String command = scanner.nextLine();

            switch (command) {
                case "create":
                    System.out.println("Enter the name of the user:");
                    String newUser = scanner.nextLine();
                    users.add(newUser);
                    System.out.println("User created successfully");
                    break;
                case "get":
                    System.out.println("Enter the index of the user:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index < users.size()) {
                        System.out.println("User " + index + ": " + users.get(index));
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case "update":
                    System.out.println("Enter the index of the user to update:");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (updateIndex < users.size()) {
                        System.out.println("Enter the new name for the user:");
                        String updatedUser = scanner.nextLine();
                        users.set(updateIndex, updatedUser);
                        System.out.println("User updated successfully");
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case "delete":
                    System.out.println("Enter the index of the user to delete:");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (deleteIndex < users.size()) {
                        users.remove(deleteIndex);
                        System.out.println("User deleted successfully");
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case "list":
                    System.out.println("List of users:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println("User " + i + ": " + users.get(i));
                    }
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        System.out.println("Thank you for using the User Management System");
    }

}
