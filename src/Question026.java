public class Question026 {

    public static void main(String[] args) {
        Question026 question026 = new Question026();
        question026.removeDuplicates(new int[]{1, 1, 2});
    }
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[current] != nums[i]) {
                nums[++current] = nums[i];
            }
        }
        return current + 1;
    }
}
