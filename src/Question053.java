import java.util.Arrays;

public class Question053 {

    public static void main(String[] args) {
        Question053 question053 = new Question053();
        question053.maxSubArray(new int[]{5, 4, -1, 7, 8});
    }
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : sum) {
            max = Math.max(max, i);
        }
        return max;
    }
}
