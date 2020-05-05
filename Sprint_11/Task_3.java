static Plant tryCreatePlant(String type, String color, String name){
        Plant plant = null;
        try {
            plant = new Plant(type, color, name);
        } catch(ColorException  colorException) {
            return tryCreatePlant(type, "Red", name);
        } catch(TypeException typeException) {
            return tryCreatePlant("Ordinary", color, name);
        }
        return plant;
    }
