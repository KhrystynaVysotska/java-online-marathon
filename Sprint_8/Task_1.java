import java.util.Arrays;
import java.util.function.Predicate;
public class MyUtils {

    public static int getCount(int[] myIntegerArray, Predicate<Integer> positive) {
        int counter = 0;
        for (int i = 0; i < myIntegerArray.length; i++) {
            if (positive.test(myIntegerArray[i])) {
                ++counter;
            }
        }

        return counter;
    }
}
