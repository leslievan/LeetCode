public class Question075 {

    public static void main(String[] args) {
        Question075 question075 = new Question075();
        question075.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int i = 0;
        while (count[0]-- > 0) {
            nums[i++] = 0;
        }
        while (count[1]-- > 0) {
            nums[i++] = 1;
        }
        while (count[2]-- > 0) {
            nums[i++] = 2;
        }
    }
}
