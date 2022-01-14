/**
 * Creates a new user into the Bank system
 */
public class User {
    private String name;
    private int age;
    // arg accepting constructor, enter name
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Welcome to Daniel & Douglas Bank!");
        System.out.println("__________________________________");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("––––––––––––––––––––––––––––––––––");
    }
    // no arg constructor
    public User() {
        name = "";
        age = 0;
    }
}
