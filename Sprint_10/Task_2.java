class ArrayUtil {
   public static  <T> T setAndReturn(T[] values, T value, int position) {
        T newValue = values[position] = value;
        return newValue;
    }
}
