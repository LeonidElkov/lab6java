package nomer2;

@Two(first = "Example", second = 31) // Применяем аннотацию к классу
public class exampletwo {

    private String message;

    // Конструктор
    public exampletwo(String message) {
        this.message = message;
    }

    // Геттер
    public String getMessage() {
        return message;
    }
}
