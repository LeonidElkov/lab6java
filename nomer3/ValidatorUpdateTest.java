package nomer3;

import nomer1.ValidateException;
import nomer2.Validate;
import org.junit.Test;
import static org.junit.Assert.*;

// Тестовый класс для ValidatorUpdate
public class ValidatorUpdateTest {

    @Validate({HumanTestsUpd.class}) // Указываем, что этот класс будет проверяться с использованием тестов из HumanTestsUpd
    public static class TestHuman {
        private int age;

        public TestHuman(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    @Test
    public void testValidateSuccess() throws ValidateException {
        TestHuman human = new TestHuman(25); // Создаем объект с корректным возрастом
        ValidatorUpdate.validate(human); // Ожидаем, что валидация пройдет успешно
    }

    @Test(expected = ValidateException.class)
    public void testValidateFailure() throws ValidateException {
        TestHuman human = new TestHuman(-5); // Создаем объект с некорректным возрастом
        ValidatorUpdate.validate(human); // Ожидаем, что валидация выбросит ValidateException
    }
}
