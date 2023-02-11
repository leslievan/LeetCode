import java.util.ArrayDeque;
import java.util.Deque;

public class Question020 {

    public static void main(String[] args) {
        Question020 question020 = new Question020();
        question020.isValid("()");
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character toMatch = stack.pop();
                    if ((aChar == ')' && toMatch != '(')
                            || (aChar == ']' && toMatch != '[')
                            || (aChar == '}' && toMatch != '{')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
