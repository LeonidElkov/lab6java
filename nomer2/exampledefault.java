package nomer2;

// Применение аннотации @Default к классу
@Default(value = String.class)
public class exampledefault {

    @Default(value = Integer.class) // Применение аннотации к полю
    private int myField;

    public exampledefault() {
        // Конструктор
    }

    // Геттер для поля
    public int getMyField() {
        return myField;
    }
}
