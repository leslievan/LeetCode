import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Question090 {

    public static void main(String[] args) {
        Question090 question090 = new Question090();
        question090.subsetsWithDup(new int[]{1, 2, 2});
    }

    int theLastPopValue = Integer.MIN_VALUE;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayDeque<>(), result);
        return result;
    }

    void dfs(int[] nums, int i, Deque<Integer> deque, List<List<Integer>> result) {
        if (i >= nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (theLastPopValue == nums[j]) {
                continue;
            }
            deque.push(nums[j]);
            result.add(new ArrayList<>(deque));
            dfs(nums, j + 1, deque, result);
            theLastPopValue = deque.pop();
        }
    }

}
