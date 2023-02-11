import java.util.ArrayDeque;
import java.util.Deque;

public class Question071 {

    public static void main(String[] args) {
        Question071 question071 = new Question071();
        question071.simplifyPath("/home");
    }

    public String simplifyPath(String path) {
        String[] split = path.split("\\/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : split) {
            if (s.equals(".") || s.isBlank()) {
            } else if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(s);
            }
        }

        return "/" + String.join("/", deque);
    }
}
