import java.util.function.Predicate;
import java.util.Set;

public class MyUtils{
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> resultPredication = predicates.stream().reduce(Predicate::and).orElse(x->true);
        return resultPredication;
    }
}
