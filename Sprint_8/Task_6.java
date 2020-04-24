import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        List<Integer> appropriateNumbers = new ArrayList<>();
        for(Integer number:numbers) {
           if(pr.test(number)) {
               appropriateNumbers.add(number);
           }
        }
        int max = Collections.max(appropriateNumbers);
        return max;
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> myLovelyFunction, Predicate<Integer> predicate) {
       return myLovelyFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> pr) {
        return getFilterdValue(MyUtils::findMaxByCondition, pr);
    }
}
