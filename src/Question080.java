public class Question080 {

    public static void main(String[] args) {
        Question080 question080 = new Question080();
        question080.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, count = 0, current = nums[0];
        while (i < nums.length) {
            if (nums[i] == current) {
                count++;
            } else {
                count = 1;
                current = nums[i];
            }
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
