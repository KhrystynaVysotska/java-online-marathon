import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componemtCount);  
}
interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}
interface Rating {
    int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients = new HashMap<>();

    public Caffee(String name, int rating, Map<String, Integer> ingredients) {
        super();
        this.name = name;
        this.rating = rating;
        this.ingredients = ingredients;
    }
    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    public Caffee() {
        
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> coffee = new HashMap<>();
        coffee.put("Water", 100);
        coffee.put("Arabica", 20);
        return coffee;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int compomemtCount) {
        return null;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + rating;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Caffee other = (Caffee) obj;
        if (ingredients == null) {
            if (other.ingredients != null)
                return false;
        } else if (!ingredients.equals(other.ingredients))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rating != other.rating)
            return false;
        return true;
    }
}

class Espresso extends Caffee {

    public Espresso(String name, int rating, Map<String, Integer> ingredients) {
        super(name, rating, ingredients);
    }
    public Espresso(String name, int rating) {
        super(name, rating);
    }
    
    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> espresso = new HashMap<>();
        espresso.put("Water", 50);
        espresso.put("Arabica", 20);
        return espresso;
    }
    
}
class Cappuccino extends Caffee {

    public Cappuccino(String name, int rating, Map<String, Integer> ingredients) {
        super(name, rating, ingredients);
    }
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }
    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> cappuccino = new HashMap<>();
        cappuccino.put("Water", 100);
        cappuccino.put("Arabica", 20);
        cappuccino.put("Milk", 50);
        return cappuccino;
    }
}
public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> caffeeOrders) {
        Map<String,Double> averageRating = new HashMap<>();
        List<Caffee> espressoOrders = new ArrayList<>();
        List<Caffee> cappuccinoOrders = new ArrayList<>();
        List<Caffee> coffeeOrders = new ArrayList<>();
        Set<String> drinkNames = new LinkedHashSet<>();
        
        for(Caffee drinkOrder:caffeeOrders) {
            if(drinkOrder instanceof Espresso) {
                espressoOrders.add((Espresso)drinkOrder);
            } else if(drinkOrder instanceof Cappuccino) {
                cappuccinoOrders.add((Cappuccino)drinkOrder);
            } else if(drinkOrder instanceof Caffee) {
                coffeeOrders.add(drinkOrder);
            }
        }
        
        for(Caffee drinkOrder:caffeeOrders) {
            drinkNames.add(drinkOrder.getName());
        }
        
        for(String drink:drinkNames) {
            if(drink.equals("Espresso")) {
                averageRating.put(drink, countAverageRating(espressoOrders));
            } else if (drink.equals("Cappuccino")) {
                averageRating.put(drink, countAverageRating(cappuccinoOrders));
            } else if (drink.equals("Caffee")) {
                averageRating.put(drink, countAverageRating(coffeeOrders));
            }
        }
        return averageRating;
    }
    public static double countAverageRating(List<Caffee> caffees) {
        double generalRating = 0.0;
        int amountOfOrders = 0;
        for(Caffee eachCaffee:caffees) {
            generalRating += eachCaffee.getRating();
            ++amountOfOrders;
        }
        return generalRating/amountOfOrders;
    }
}
