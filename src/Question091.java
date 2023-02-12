public class Question091 {

    public static void main(String[] args) {
        Question091 question0091 = new Question091();
        question0091.numDecodings("27");
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = (validateToken(chars, 1, 1) ? dp[0] : 0)
                + (validateToken(chars, 0, 1) ? 1 : 0);
        for (int i = 2; i < n; i++) {
            dp[i] = (validateToken(chars, i, i) ? dp[i - 1] : 0)
                    + (validateToken(chars, i - 1, i) ? dp[i - 2] : 0);
        }
        return dp[n - 1];
    }

    boolean validateToken(char[] chars, int i, int j) {
        if (chars[i] == '0') {
            return false;
        } else if (j > i) {
            if (chars[i] > '2') {
                return false;
            } else {
                return chars[i] != '2' || chars[j] <= '6';
            }
        }
        return true;
    }
}
