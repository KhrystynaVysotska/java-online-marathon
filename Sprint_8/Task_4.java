import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
    
    DecisionMethod goShopping = (param1, param2) -> {
        if (param1 == "product1" && param2 > 10) {
            return true;
        } else {
            return false;
        }
    };
}

interface DecisionMethod {
    public boolean decide(String param1, int param2);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();
    public int sale(String product, int percent) {
        int counter = 0;
        for(DecisionMethod client:clients) {
            if(client.decide(product, percent)) {
                ++counter;
            }
        }
        return counter;
    }
}
