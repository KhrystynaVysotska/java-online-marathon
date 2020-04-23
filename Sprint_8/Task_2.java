import java.util.function.Consumer;
import java.util.Arrays;
public class App {

    static Consumer<double[]> cons = new Consumer<double[]>() {

        @Override
        public void accept(double[] myDoubleArray) {
            for(int i = 0; i < myDoubleArray.length; i++) {
                if(myDoubleArray[i] > 2) {
                    myDoubleArray[i] *= 0.8;
                } else {
                    myDoubleArray[i] *= 0.9;
                }
            }
            
        }         
    };
    
    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] modifiedArray = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(modifiedArray);
        return modifiedArray;
    }
}
