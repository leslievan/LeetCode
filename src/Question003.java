public class Question003 {

    public static void main(String[] args) {
        Question003 question003 = new Question003();
        System.out.println(question003.lengthOfLongestSubstring("nfpdmpi"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int begin = 0;
        int[] location = new int[128];
        for (int i = 0; i < location.length; ++i) {
            location[i] = -1;
        }
        for (int i = 0; i < s.length(); ++i) {
            char currentCh = s.charAt(i);
            int lastLocation = location[currentCh];
            if (lastLocation >= begin) {
                begin = lastLocation + 1;
            } else {
                maxLength = Integer.max(i - begin + 1, maxLength);
            }
            location[currentCh] = i;
        }
        return maxLength;
    }
}
