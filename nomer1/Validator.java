package nomer1;

import java.lang.reflect.Method;

// Класс Validator, содержащий метод для валидации объектов
public class Validator {

    // Метод для валидации объекта с использованием тестов из указанного класса
    public static void validate(Object obj, Class<?> testClass) throws ValidateException {
        // Получаем все методы тестирования из указанного класса
        Method[] methods = testClass.getDeclaredMethods();

        // Перебираем все методы тестирования
        for (Method method : methods) {
            try {
                // Вызываем статический метод теста, передавая тестируемый объект
                method.invoke(null, obj); // null, так как метод статический
            } catch (Exception e) {
                // Если тест не прошел, обрабатываем исключение
                if (e.getCause() instanceof ValidateException) {
                    // Если причина исключения - ValidateException, выбрасываем его
                    throw (ValidateException) e.getCause();
                }
            }
        }
    }
}
