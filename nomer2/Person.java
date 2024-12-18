package nomer2;
//exampletostring

@ToString(value = "YES")
public class Person { // Аннотируем класс
    @ToString(value = "NO") // Аннотируем поле
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределяем метод toString
    @Override
    public String toString() {
        return "Person{" + "Имя = '" + name + '\'' + ", возраст = " + age + '}';
    }
}
