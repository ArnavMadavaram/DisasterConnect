
public class User {
    String name;
    String location;

    public User(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void showUserInfo() {
        System.out.println("User: " + name + " | Location: " + location);
    }
}
