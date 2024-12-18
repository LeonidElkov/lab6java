package nomer2;

// Пример класса, аннотированного @Cache
@Cache(value = {"User Cache", "ProductCache"}) // Применяем аннотацию к классу с указанием значений
public class DataService {

    public void fetchData() {
        System.out.println("Fetching data...");
    }
}
