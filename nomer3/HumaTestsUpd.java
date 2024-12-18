package nomer3;

import nomer1.ValidateException;

// Класс, содержащий методы для тестирования объекта HumanUpdate
public class HumanTestsUpd {

    // Статический метод тестирования, проверяющий, что возраст в допустимом диапазоне
    public static void test1(HumanUpdate human) throws ValidateException {
        // Проверяем, что возраст человека находится в диапазоне от 1 до 200
        if (human.getAge() < 1 || human.getAge() > 200) {
            // Если условие не выполняется, выбрасываем исключение ValidateException
            throw new ValidateException("ошибка в test1: возраст человека не в диапазоне от 1 до 200");
        }
    }
}
