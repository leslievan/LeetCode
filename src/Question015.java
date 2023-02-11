import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question015 {

    public static void main(String[] args) {
        Question015 question015 = new Question015();
        question015.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 遍历数组
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针寻找匹配值
            int j = i + 1, k = nums.length - 1;
            int left = nums[j], right = nums[k];
            while (j < k) {
                // 匹配则添加到结果列表
                if (left + right == -nums[i]) {
                    result.add(Arrays.asList(left, right, nums[i]));
                    // 过滤重复结果
                    while (j < k && nums[++j] == left) {
                    }
                    left = nums[j];
                    while (j < k && nums[--k] == right) {
                    }
                    right = nums[k];
                } else if (left + right > -nums[i]) {
                    // 不匹配，若过大则右指针左移
                    k--;
                    right = nums[k];
                } else {
                    // 不匹配，若过小则左指针右移
                    j++;
                    left = nums[j];
                }
            }
        }
        return result;
    }
}
