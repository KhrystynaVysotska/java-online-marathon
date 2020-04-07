import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class MyUtils {

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        boolean result = false;
        List<String> mappedList = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            mappedList.add(entry.getValue());
        }
        if ((list.size() == 0) && (mappedList.size() == 0)) {
            result = true;
        } else if ((list.size() != 0) && (mappedList.size() != 0)) {
            for (String element : list) {
                if (mappedList.contains(element)) {
                    for(String anotherElement : mappedList) {
                        if(list.contains(anotherElement)) {
                            result = true;
                        } else {
                            result = false;
                            break;
                        }
                    }
                } else {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }

        return result;
    }
}
