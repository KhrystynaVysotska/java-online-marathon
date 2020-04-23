import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
public class App {
     static BinaryOperator<String> greetingOperator = (firstName, lastName) -> "Hello " + firstName + " " + lastName
            + "!!!";
    
    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> operator){
        List<String> greetings = new ArrayList<>();
        for(Person person:people) {
            greetings.add(operator.apply(person.name, person.surname));
        }
        return greetings;
     }
}
