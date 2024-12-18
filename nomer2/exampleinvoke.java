package nomer2;

public class exampleinvoke {

    @Invoke // Применение аннотации @Invoke к методу
    public void AnnotatedMethod() {
        System.out.println("Этот метод аннотирован @Invoke.");
    }

    public void anotherMethod() {
        System.out.println("Этот метод не аннотирован.");
    }
}
