import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class MyUtils {
   static class SortList implements Comparator<String>{

        @Override
        public int compare(String firstElement, String secondElement) {
            int result = Integer.compare(firstElement.length(), secondElement.length());
            if(result != 0) {
                return result;
            } else {
                return firstElement.compareTo(secondElement);
            }
        }
        
    }
    public List<String> strSort(List<String> originList) {
        List<String> copiedList = originList.stream()
                .collect(Collectors.toList());
        SortList comparator = new MyUtils.SortList();
        Collections.sort(copiedList, comparator);
        return copiedList;
    }
}
