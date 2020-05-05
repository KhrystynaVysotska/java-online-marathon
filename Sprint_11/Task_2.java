class Plant {
    private Type type;
    private Color color;
    private String name;
    public Plant(String type, String color, String name) throws ColorException, TypeException {
        this.name = name;
        try {
            Color.valueOf(color);
        } catch(IllegalArgumentException e) {
            throw new ColorException("Inappropriate color");
        }
        this.color = Color.valueOf(color);
        try {
            Type.valueOf(type);
        } catch(IllegalArgumentException e) {
            throw new TypeException("Inappropriate type");
        }
        this.type = Type.valueOf(type);
    }
    @Override
    public String toString() {
        return "{type:" + type + ", color:" + color + ", name:" + name + "}";
    }   
    
}

enum Color {
    White, Red, Blue
}

enum Type {
    Rare, Ordinary
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}
