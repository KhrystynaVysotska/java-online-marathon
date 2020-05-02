class ArrayUtil {
    public static double averageValue(Array<? extends Number> array) {
        double sum = 0.0;
        for(int i = 0; i < array.length(); i++) {
            sum += array.get(i).doubleValue();
        }
        
        return sum/array.length();
    }
}
