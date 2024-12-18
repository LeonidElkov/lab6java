package nomer3;

import nomer1.HumanTests;
import nomer2.Validate;

// Класс Human с аннотацией @Validate
@Validate(value = {HumanTests.class}) // Указываем, что тесты находятся в классе HumanTests
public class HumanUpdate {
    private int age; // поле возраста

    // Конструктор для инициализации объекта Human с заданным возрастом
    public HumanUpdate(int age) {
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
