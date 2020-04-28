import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MyUtils {
    public boolean verifyBrackets(String text) {
        char[] charInText = new char[text.length()];
        char[] onlyBracketsArray = new char[text.length()];
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            charInText[i] = text.charAt(i);
        }
        for (int i = 0; i < charInText.length; i++) {
            if (charInText[i] == '\\') {
                i++;
            } else {
                onlyBracketsArray[k] = charInText[i];
                k++;
            }
        }
        String splittedString = "";
        for (int i = 0; i < onlyBracketsArray.length; i++) {
            if (onlyBracketsArray[i] != 0) {
                splittedString += onlyBracketsArray[i];
            }
        }
        if (splittedString.contains("([)]")) {
            return false;
        } else if (splittedString.contains("({)}")) {
            return false;
        } else if (splittedString.contains("[{]}")) {
            return false;
        } else {
            int foundedBracketsWithoutPair = 0;
            for (int i = 0; i < splittedString.length(); ++i) {
                char c = splittedString.charAt(i);
                switch (c) {
                case '(':
                    foundedBracketsWithoutPair++;
                    break;
                case '{':
                    foundedBracketsWithoutPair++;
                    break;
                case '[':
                    foundedBracketsWithoutPair++;
                    break;
                case ')':
                    foundedBracketsWithoutPair--;
                    if (foundedBracketsWithoutPair < 0) {
                        return false;
                    }
                    break;
                case '}':
                    foundedBracketsWithoutPair--;
                    if (foundedBracketsWithoutPair < 0) {
                        return false;
                    }
                    break;
                case ']':
                    foundedBracketsWithoutPair--;
                    if (foundedBracketsWithoutPair < 0) {
                        return false;
                    }
                    break;
                }
            }
            return foundedBracketsWithoutPair == 0;
        }
    }
}
