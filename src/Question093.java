import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Question093 {

    public static void main(String[] args) {
        Question093 question093 = new Question093();
        question093.restoreIpAddresses("000256");
    }

    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        dfs(s, 0, new ArrayDeque<>(), result);
        return result.stream().filter(str -> str.length() == s.length() + 3).collect(Collectors.toList());
    }

    void dfs(String s, int k, Deque<String> middle, List<String> result) {
        if (s.length() - k > (4 - middle.size()) * 3) {
            return;
        }
        if (middle.size() == 4) {
            result.add(String.join(".", middle));
        }
        if (k > s.length()) {
            return;
        }
        if (validate255(s, k, k + 1)) {
            middle.addLast(s.substring(k, k + 1));
            dfs(s, k + 1, middle, result);
            middle.removeLast();
        }
        if (s.charAt(k) != 0) {
            if (validate255(s, k, k + 2)) {
                middle.addLast(s.substring(k, k + 2));
                dfs(s, k + 2, middle, result);
                middle.removeLast();
            }
            if (validate255(s, k, k + 3)) {
                middle.addLast(s.substring(k, k + 3));
                dfs(s, k + 3, middle, result);
                middle.removeLast();
            }
        }
    }

    boolean validate255(String s, int i, int j) {
        if (j > s.length()) { // 超过下标的不行
            return false;
        }
        if (j - i > 1 && s.charAt(i) == '0') { // 含有前导 0 的 token 不行
            return false;
        }
        int add = 0;
        for (int start = i; start < j; start++) {
            add = 10 * add + s.charAt(start) - '0';
        }
        return add <= 255;
    }
}
