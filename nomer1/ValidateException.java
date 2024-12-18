package nomer1;

public class ValidateException extends Exception { //создание пользовательского исключения
    // Конструктор, принимающий сообщение об ошибке
    public ValidateException(String message) {
        super(message); // Передача сообщения в родительский класс
    }
}
