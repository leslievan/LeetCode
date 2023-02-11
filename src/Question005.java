public class Question005 {

    public static void main(String[] args) {
        Question005 question005 = new Question005();
        System.out.println(question005.longestPalindrome("babad"));;
    }

    public String longestPalindrome(String s) {
        int maxLength = 0;
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int bias = midExpand(s, i, i);
            if (bias * 2 + 1 > maxLength) {
                begin = i - bias;
                end = i + bias + 1;
                maxLength = bias * 2 + 1;
            }
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                bias = midExpand(s, i, i + 1);
                if (bias * 2 + 2 > maxLength) {
                    begin = i - bias;
                    end = i + bias + 2;
                    maxLength = bias * 2 + 2;
                }
            }
        }
        return s.substring(begin, end);
    }

    public int midExpand(String s, int i, int j) {
        int count = -1;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i--) == s.charAt(j++)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
