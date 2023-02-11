import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question022 {

    public static void main(String[] args) {
        Question022 question022 = new Question022();
        System.out.println(Arrays.deepToString(question022.generateParenthesis(3).toArray()));;
    }
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            result = generate(result);
        }
        return result.stream().toList();
    }

    public Set<String> generate(Set<String> input) {
        if (input == null || input.size() == 0) {
            return Set.of("()");
        }
        Set<String> output = new HashSet<>();
        for (String s : input) {
            StringBuffer buffer = new StringBuffer(s);
            for (int i = 0; i < buffer.length(); ++i) {
                buffer.insert(i, "()");
                output.add(buffer.toString());
                buffer.delete(i, i + 2);
            }
        }
        return output;
    }
}
