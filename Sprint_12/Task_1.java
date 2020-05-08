import java.util.function.BinaryOperator;
public class ParallelCalculator implements Runnable {
    
    public int result; 
    
    public ParallelCalculator(BinaryOperator<Integer> operator, int operand1, int operand2) {
        result = operator.apply(operand1, operand2);
    }
    
    @Override
    public void run() {
        
    }
}
