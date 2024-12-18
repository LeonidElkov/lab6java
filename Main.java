import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import nomer1.*;
import nomer2.*;
import nomer3.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Рефлексия. Валидация.");
            System.out.println("2. Invoke.");
            System.out.println("3. Default.");
            System.out.println("4. ToString.");
            System.out.println("5. Validate.");
            System.out.println("6. Two.");
            System.out.println("7. Cache.");
            System.out.println("8. Обработка аннотаций. Валидация.");
            System.out.println("Выберите действие от 0 до 8: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Введите целое число: ");
                scanner.next();
            }
            int d = scanner.nextInt();
            if (d < 0 || d > 9) {
                System.out.println("Введено неверное значение!");
                continue;
            }
            switch (d) {
                case 0:
                    System.out.println("Программа завершена.");
                    return;

                case 1:
                    System.out.print("Введите возраст: "); // Запрашиваем ввод возраста

                    try {
                        int age = scanner.nextInt(); // Читаем возраст от пользователя

                        // Создаем объект Human с введенным возрастом
                        Human h = new Human(age);
                        System.out.println(h); // Выводим информацию о человеке

                        // Выполняем валидацию объекта h с использованием тестов из HumanTests
                        Validator.validate(h, HumanTests.class);
                    } catch (ValidateException e) {
                        // обработка исключения ValidateException
                        System.out.println("ValidateException: " + e.getMessage());
                    } catch (Exception e) {
                        // обработка других исключений
                        System.out.println("Произошла ошибка: " + e.getMessage());
                    }
                    break;

                case 2:
                    exampleinvoke example = new exampleinvoke();

                    // Получаем все методы класса Example
                    Method[] methods = exampleinvoke.class.getDeclaredMethods();

                    for (Method method : methods) {
                        // Проверяем, имеет ли метод аннотацию @Invoke
                        if (method.isAnnotationPresent(Invoke.class)) {
                            try {
                                // Вызываем метод, если он аннотирован
                                method.invoke(example);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;

                case 3:
                    // Получаем класс exampledefault
                    Class<exampledefault> myClass = exampledefault.class;

                    // Проверяем аннотацию класса
                    if (myClass.isAnnotationPresent(Default.class)) {
                        Default defaultAnnotation = myClass.getAnnotation(Default.class);
                        System.out.println("Класс exampledefault аннотирован @Default с value: " + defaultAnnotation.value().getName());
                    } else {
                        System.out.println("Аннотации нет.");
                    }

                    // Проверяем аннотацию поля
                    try {
                        Field field = myClass.getDeclaredField("myField");
                        if (field.isAnnotationPresent(Default.class)) {
                            Default defaultFieldAnnotation = field.getAnnotation(Default.class);
                            System.out.println("Поле myField аннотировано @Default с value: " + defaultFieldAnnotation.value().getName());
                        } else {
                            System.out.println("Аннотации нет.");
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    Person person = new Person("Евгений", 30);
                    System.out.println(person); // вывод информации о человеке
                    break;

                case 5:
                    // Получаем аннотацию @Validate из класса User
                    if (User.class.isAnnotationPresent(Validate.class)) {
                        Validate validateAnnotation = User.class.getAnnotation(Validate.class);
                        System.out.println("Класс User аннотирован @Validate с классами: ");
                        for (Class<?> clazz : validateAnnotation.value()) {
                            System.out.println(clazz.getName());
                        }
                    }
                    break;

                case 6:
                    // Проверяем наличие аннотации @Two у класса SampleClass
                    if (exampletwo.class.isAnnotationPresent(Two.class)) {
                        Two twoAnnotation = exampletwo.class.getAnnotation(Two.class);
                        System.out.println("Класс SampleClass аннотирован @Two с параметрами:");
                        System.out.println("first: " + twoAnnotation.first());
                        System.out.println("second: " + twoAnnotation.second());
                    }
                    break;

                case 7:
                    // Проверяем наличие аннотации @Cache у класса DataService
                    if (DataService.class.isAnnotationPresent(Cache.class)) {
                        Cache cacheAnnotation = DataService.class.getAnnotation(Cache.class);
                        System.out.println("Класс DataService аннотирован @Cache с параметрами:");
                        for (String cacheName : cacheAnnotation.value()) {
                            System.out.println("Cache name: " + cacheName);
                        }
                    } else {
                        System.out.println("Аннотации нет.");
                    }

                case 8:
                    System.out.print("Введите возраст: ");
                    try {
                        int age = scanner.nextInt(); // Читаем возраст от пользователя

                        // Создаем объект HumanUpdate с введенным возрастом
                        HumanUpdate human = new HumanUpdate(age);
                        System.out.println(human); // Выводим информацию о человеке

                        // Выполняем валидацию объекта human с использованием теста из HumanTestsUpd
                        HumanTestsUpd.test1(human);
                        ValidatorUpdate.validate(human);
                    } catch (ValidateException e) {
                        // Обработка исключения ValidateException
                        System.out.println("ValidateException: " + e.getMessage());
                    } catch (Exception e) {
                        // Обработка других исключений
                        System.out.println("Произошла ошибка: " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
