import java.util.Arrays;
import java.util.Comparator;
public class MyUtils {
    static class SortArray implements Comparator<int[]> {

        @Override
        public int compare(int[] firstRow, int[] secondRow) {
           if(firstRow.length == 0) {
               return Integer.compare(secondRow[0], 0);
           } else if (secondRow.length == 0) {
               return Integer.compare(0,firstRow[0]);
           } else {
               int result = Integer.compare(secondRow[0], firstRow[0]);
               if(result != 0) {
                   return result;
               } else {
                   if ((firstRow.length == 1)&&(secondRow.length > 1)) {
                       return Integer.compare(0, secondRow[1]);
                   } else if ((firstRow.length > 1)&&(secondRow.length == 1)) {
                       return Integer.compare(firstRow[1], 0);
                   } else if ((firstRow.length == 1)&&(secondRow.length == 1)) {
                       return 0;
                   } else {
                       return Integer.compare(firstRow[1], secondRow[1]);
                   }
               }
           }
        }
    }
    public int[][] arrSort(int[][] arr) {
        SortArray comparator = new MyUtils.SortArray();
        Arrays.sort(arr, comparator);
        return arr;
    }
}
