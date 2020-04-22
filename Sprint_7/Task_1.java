class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() { 
        
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }
    
    public static class PizzaBuilder {
        private Pizza pizza;
        
        private PizzaBuilder() {
           pizza = new Pizza();
        }
        
        public PizzaBuilder addCheese(String cheese) {
            pizza.cheese = cheese;
            return new PizzaBuilder();
        }
        
        public PizzaBuilder addMeat(String meat) {
            pizza.meat = meat;
            return new PizzaBuilder();
        }
        
        public PizzaBuilder addSeafood(String seaFood) {
            pizza.seafood = seaFood;
            return new PizzaBuilder();
        }
        
        public PizzaBuilder addVegetable(String vegetable) {
            pizza.vegetable = vegetable;
            return new PizzaBuilder();
        }
        
        public PizzaBuilder addMushroom(String mushroom) {
            pizza.mushroom = mushroom;
            return new PizzaBuilder();
        }
        
        public Pizza build() {
            return pizza;
        }
    }
}
class Oven {
    public static Pizza cook() {
        Pizza.PizzaBuilder pizzaBuilder = Pizza.base();
        pizzaBuilder.addCheese("mozarella");
        pizzaBuilder.addMeat("chicken");
        pizzaBuilder.addMushroom("mushroom");
        pizzaBuilder.addVegetable("tomatoes");
        pizzaBuilder.addSeafood("seafood");
        return pizzaBuilder.build();
    }
}
