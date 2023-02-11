public class Question055 {

    public static void main(String[] args) {
        Question055 question055 = new Question055();
        question055.canJump(new int[]{1, 2, 3});
    }

    public boolean canJump(int[] nums) {
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return cover >= nums.length - 1;
    }
}
