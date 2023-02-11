public class Question045 {

    public static void main(String[] args) {
        Question045 question045 = new Question045();
        question045.jump(new int[]{2, 3, 1, 1, 4});
    }

    public int jump(int[] nums) {
        int pace = 0;
        // 第 0 步边界和能达到的最远处均为 0
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                pace++;
            }
        }
        return pace;
    }
}
