import java.util.Arrays;

public class Question031 {

    public static void main(String[] args) {
        Question031 question031 = new Question031();
        question031.nextPermutation(new int[]{3, 5, 4, 3, 2, 1});
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int larger = Integer.MAX_VALUE;
        int idx = -1;
        int i = nums.length;
        while (--i > 0) {
            if (nums[i] > nums[i - 1]) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] <= larger) {
                        larger = nums[j];
                        idx = j;
                    }
                }
                break;
            }
        }

        if (idx > 0) {
            int temp = nums[idx];
            nums[idx] = nums[i - 1];
            nums[i - 1] = temp;
            Arrays.sort(nums, i, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
