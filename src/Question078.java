import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question078 {

    public static void main(String[] args) {
        Question078 question078 = new Question078();
        question078.subsets(new int[]{1, 2, 3});
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int k = result.size();
            for (int i = 0; i < k; i++) {
                List<Integer> subset = new ArrayList<>();
                subset.add(num);
                subset.addAll(result.get(i));
                result.add(subset);
            }
        }
        return result;
    }
}
