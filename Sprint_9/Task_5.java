import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public String reformatLines(String text) {
        String newText = text.replaceAll("\\s+", " ").trim();
        List<String> result = new ArrayList<String>();
        String resultString = "";
        int length = newText.length() / 60;
        if(newText.length() <= 60) {
            return newText;
        }
        for (int i = 1; i <= length; i++) {
                result.add(newText.substring(60 * i - 60, i * 59).trim());
                result.add("\n");
                if(i == length) {
                    result.add(newText.substring(i * 59).trim());
                }
        }

        for (String string : result) {
            resultString += string;
        }
        return resultString;
    }
}
