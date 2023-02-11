import java.util.Arrays;

public class Question033 {

    public static void main(String[] args) {
        Question033 question033 = new Question033();
        System.out.println(question033.search(new int[]{3, 1}, 1));
        ;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1) {
            return Math.max(-1, Arrays.binarySearch(nums, target));
        }
        // 0 -> i, i+1 -> nums.length-1
        if (target > nums[nums.length - 1]) {
            return Math.max(-1, Arrays.binarySearch(nums, 0, i + 1, target));
        } else {
            return Math.max(-1, Arrays.binarySearch(nums, i + 1, nums.length, target));
        }
    }
}
