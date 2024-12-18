package nomer2;
//exampletostring
@ToString(value = "YES") // Применяем аннотацию к классу
public class Person {

    @ToString(value = "NO") // Применяем аннотацию к полю
    private String name;

    private int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Переопределяем метод toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        if (this.getClass().isAnnotationPresent(ToString.class)) {
            ToString toStringAnnotation = this.getClass().getAnnotation(ToString.class);
            if ("YES".equals(toStringAnnotation.value())) {
                sb.append("name='").append(name).append('\'');
                sb.append(", age=").append(age);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

