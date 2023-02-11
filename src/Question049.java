import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(this::getIdentifier)).values().stream().toList();
    }

    public String getIdentifier(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
