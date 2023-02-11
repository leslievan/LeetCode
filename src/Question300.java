import java.util.Arrays;

public class Question300 {

    public static void main(String[] args) {
        Question300 question300 = new Question300();
        question300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    public int lengthOfLIS(int[] nums) {
        /* 定义 dp 数组，初始化为 1
        * dp[i] 表示以第 i 个元素结尾的最长严格递增子序列的长度 */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; ++i) {
            int max = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
