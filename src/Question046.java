import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Question046 {

    public static void main(String[] args) {
        Question046 question046 = new Question046();
        question046.permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> middle = new ArrayList<>();
        permutation(nums, 0, middle);
        return result.stream().distinct().collect(Collectors.toList());
    }

    public void permutation(int[] nums, int start, List<Integer> middle) {
       if (middle.size() == nums.length) {
            result.add(new ArrayList<>(middle));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = 0; i < middle.size() + 1; i++) {
            middle.add(i, nums[start]);
            permutation(nums, start + 1, middle);
            middle.remove(i);
        }
    }
}
