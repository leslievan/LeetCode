import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question077 {

    public static void main(String[] args) {
        Question077 question077 = new Question077();
        question077.combine(4, 2);
    }
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> middle = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        permutation(n, 1, k);
        return result;
    }

    void permutation(int end, int start, int k) {
        if (middle.size() == k) {
            result.add(new ArrayList<>(middle));
            return;
        }
        if (start >= end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            middle.addLast(i);
            permutation(end, i + 1, k);
            middle.removeLast();
        }
    }
}
