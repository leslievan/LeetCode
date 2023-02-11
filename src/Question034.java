import java.util.Arrays;

public class Question034 {

    public static void main(String[] args) {
        Question034 question034 = new Question034();
        System.out.println(Arrays.toString(question034.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) {
            return new int[]{-1, -1};
        } else {
            int i = idx, j = idx;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            while (j < nums.length && nums[j] == target) {
                j++;
            }
            return new int[]{i + 1, j - 1};
        }
    }
}
