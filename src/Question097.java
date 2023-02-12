public class Question097 {

    boolean[][] dp = new boolean[101][101];

    public static void main(String[] args) {
        Question097 question097 = new Question097();
        System.out.println(question097.isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"));
        ;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                dp[i][j] = (str1[i] == str3[i + j] && (i == 0 || dp[i - 1][j]))
                        || (str2[j] == str3[i + j] && (j == 0 || dp[i][j - 1]));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
