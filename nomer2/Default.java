package nomer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации @Default
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Аннотация может применяться к типам и полям
public @interface Default {
    Class<?> value(); // Обязательное свойство value типа Class
}
