package nomer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определение аннотации @Invoke
@Target(ElementType.METHOD) // Аннотация может применяться только к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface Invoke {
}
