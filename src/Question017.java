import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question017 {

    private List<String> result = new ArrayList<>();
    private char[][] alphabet = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        Question017 question017 = new Question017();
        System.out.println(question017.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        StringBuffer buffer = new StringBuffer();
        recurse(digits, 0, buffer);
        return result;
    }

    public void recurse(String digits, int index, StringBuffer buffer) {
        if (buffer.length() == digits.length()) {
            result.add(buffer.toString());
            return;
        }
        char current = digits.charAt(index);
        char[] chars = alphabet[current - '2'];
        for (char aChar : chars) {
            buffer.append(aChar);
            recurse(digits, index + 1, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
