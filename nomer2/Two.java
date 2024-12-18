package nomer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @Two
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target(ElementType.TYPE) // Можем применять только к типам (классам)
public @interface Two {
    // Обязательные свойства
    String first(); // Первое свойство типа String
    int second();   // Второе свойство типа int
}
