package nomer3;

import nomer1.ValidateException;
import nomer2.Validate;

import java.lang.reflect.Method;

// Класс ValidatorUpdate, содержащий метод для валидации объектов
public class ValidatorUpdate {

    // Метод для валидации объектов с использованием тестов из аннотации @Validate
    public static void validate(Object... objects) throws ValidateException {
        for (Object obj : objects) {
            Class<?> objClass = obj.getClass();

            // Проверяем, аннотирован ли класс @Validate
            if (objClass.isAnnotationPresent(Validate.class)) {
                Validate validateAnnotation = objClass.getAnnotation(Validate.class);
                Class<?>[] testClasses = validateAnnotation.value();

                // Проходим по всем указанным тестам
                for (Class<?> testClass : testClasses) {
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
            } else {
                throw new ValidateException("Класс " + objClass.getSimpleName() + " не аннотирован @Validate");
            }
        }
    }
}
