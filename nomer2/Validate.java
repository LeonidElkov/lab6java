package nomer2;

//examplevalidate
@Validate(value = {String.class, Integer.class}) // Применяем аннотацию к классу
public class User {

    private String username;
    private int age;

    // Конструктор
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Геттеры
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
