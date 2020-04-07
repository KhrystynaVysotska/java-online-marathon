import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyUtils {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        List<String> phoneNumbers = new ArrayList<>();
        Map<String,List<String>> notebook = new HashMap<>();
        for(Map.Entry<String, String> entry : phones.entrySet()) {
            if(notebook.containsKey(entry.getValue())) {
                notebook.get(entry.getValue()).add(entry.getKey());
            } else {
                notebook.put(entry.getValue(), new ArrayList<>());
                notebook.get(entry.getValue()).add(entry.getKey());
            }
        }
        return notebook;
    }
}
