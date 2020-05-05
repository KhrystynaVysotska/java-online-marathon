static Plant tryCreatePlant(String type, String color, String name){
        Plant plant = null;
        try {
            plant = new Plant(type, color, name);
        } catch(ColorException  colorException) {
                try {
                    plant = new Plant(type, "Red", name);
                } catch (ColorException | TypeException e) {
                    try {
                        plant = new Plant("Ordinary", "Red", name);
                    } catch (ColorException | TypeException e1) {
                        e1.printStackTrace();
                    }
                }
        } catch(TypeException typeException) {
            try {
                plant = new Plant("Ordinary", color, name);
            } catch (ColorException | TypeException e) {
                try {
                    plant = new Plant("Ordinary", "Red", name);
                } catch (ColorException | TypeException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return plant;
    }
