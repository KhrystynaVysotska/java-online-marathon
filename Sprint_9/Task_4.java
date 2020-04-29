import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUtils {
    public String differentWords(String originalText, String modifyText) {
        String[] original = originalText.split("\\s");
        String[] modified = modifyText.split("\\s");
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < original.length; i++) {
            list.add(original[i]);
        }
        for (int i = 0; i < modified.length; i++) {
            list2.add(modified[i]);
        }
        String result = "";
        int i = 0;
        for (int j = 0; j < list2.size(); j++) {
            if (i < list.size()) {
                if (list.get(i).equals(list2.get(j))) {
                    if (i != 0) {
                        result += " ";
                    }
                    result += list.get(i);
                    ++i;
                } else {
                    if (i != 0) {
                        result += " ";
                    }
                    result += list2.get(j).toUpperCase();
                    if (j < list2.size()) {
                        //result += " ";
                    }
                }
            } else {
                if(!list.contains(list2.get(j))) {
                    result += " " + list2.get(j).toUpperCase();
                }
            }
        }
        return result;
    }
}
