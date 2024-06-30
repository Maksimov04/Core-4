package task;

public class User {
    int id;
    String name;
    int age;
    String email;
    String adress;

    public User(int id, String name, int age, String email, String adress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static void main(String[] args) {
        User user = new User(1, "Илья", 25, "example@gmail.com", "Пенза, Россия");

        System.out.println("ID: " + user.getId());
        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Адрес: " + user.getAdress());
    }

}


