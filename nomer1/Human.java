package nomer1;

public class Human {
    private int age; // поле возраста

    // Конструктор для инициализации объекта Human с заданным возрастом
    public Human(int age) {
        this.age = age; // установка возраста
    }

    // метод для получения возраста
    public int getAge() {
        return age; // возвращает текущий возраст
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Human{" + "age=" + age + '}';
    }
}
