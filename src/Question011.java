public class Question011 {

    public static void main(String[] args) {
        Question011 question011 = new Question011();
        System.out.println(question011.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        int maxArea = 0;
        area = Math.min(height[i], height[j]) * (j - i);
        maxArea = Math.max(maxArea, area);
        while (i < j) {
            int right = height[j];
            int left = height[i];
            if (left < right) { // 左低右高，左指针右移至更高处
                while (left < height[i++] && i < j) {
                }
                left = height[i];
            } else { // 左高右低，右指针左移至更高处
                while (right < height[j--] && i < j) {
                }
                right = height[j];
            }
            area = Math.min(left, right) * (j - i);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
