package nomer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @Validate
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Можем применять к типам и другим аннотациям
public @interface Validate {
    // Обязательное свойство value типа Class[]
    Class<?>[] value(); // Массив классов
}
