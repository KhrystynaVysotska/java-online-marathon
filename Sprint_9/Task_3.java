import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MyUtils {
    public String pigLatinConverter(String text) {
        if(text == "") {
            return "";
        }
        List<StringBuilder> words = new ArrayList<>();
        String[] myWords = text.split("((?=\\.)|(?<=\\.)|( )|(?=\\-)|(?<=\\-)|(?=\\!)|(?<=\\!))");
        for (int i = 0; i < myWords.length; i++) {
            words.add(new StringBuilder(myWords[i].trim()));
        }
        for (StringBuilder word : words) {
            if (Pattern.matches("^[aeiouAEIOU][0-9a-zA-Z]*", word)) {
                word.append("hay");
            } else if (Pattern.matches("^[a-zA-Z]*", word)) {
                int countOfConsonants = 0;
                for (int counter = 0; counter < word.length(); counter++) {
                    if (word.charAt(counter) != 'a' && word.charAt(counter) != 'e' && word.charAt(counter) != 'i'
                            && word.charAt(counter) != 'o' && word.charAt(counter) != 'u' && word.charAt(counter) != 'A'
                            && word.charAt(counter) != 'E' && word.charAt(counter) != 'I' && word.charAt(counter) != 'O'
                            && word.charAt(counter) != 'U') {
                        countOfConsonants++;
                    } else {
                        break;
                    }
                }
                char[] replacedLetters = new char[countOfConsonants];
                for (int i = 0; i < countOfConsonants; i++) {
                    replacedLetters[i] = word.charAt(i);
                }
                word.delete(0, countOfConsonants);
                word.append(replacedLetters);
                word.append("ay");
            }
        }
        String pigLatinStringConverter = "";
        for (int i = 0; i < words.size(); i++) {
            if (i != 0 && i + 1 != words.size()) {
                pigLatinStringConverter += " ";
            }
            pigLatinStringConverter += words.get(i).toString();
        }
        String[] splitted = Arrays.stream(pigLatinStringConverter.split("-")).map(String::trim).toArray(String[]::new);
        String result = "";
        for (int i = 0; i < splitted.length; i++) {
            if (i != 0) {
                result += "-";
            }
            result += splitted[i];
        }
        return result;
    }
}
