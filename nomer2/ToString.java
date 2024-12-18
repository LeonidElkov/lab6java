package nomer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации @ToString
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Можем применять к типам и полям
public @interface ToString {
    // Определяем необязательное свойство value с двумя вариантами значений
    String value() default "YES"; // Значение по умолчанию - YES
}
