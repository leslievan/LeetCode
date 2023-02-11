import java.util.Arrays;

public class Question081 {

    public static void main(String[] args) {
        Question081 question081 = new Question081();
        question081.search(new int[]{2, 2, 2, 3, 2, 2, 2}, 3);
    }
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return true;
            } else {
                return false;
            }
        }
        int i = 0;
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1) {
            return Arrays.binarySearch(nums, target) >= 0;
        }
        // 0 -> i, i+1 -> nums.length-1
        if (target > nums[nums.length - 1]) {
            return Arrays.binarySearch(nums, 0, i + 1, target) >= 0;
        } else {
            return Arrays.binarySearch(nums, i + 1, nums.length, target) >= 0;
        }
    }
}
