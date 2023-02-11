public class Question027 {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }
}
