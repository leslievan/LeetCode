public class Question096 {

    int[] dp = new int[20];

    {
        dp[0] = 1;
        dp[1] = 1;
    }

    public static void main(String[] args) {
        Question096 question096 = new Question096();
        question096.numTrees(3);
    }

    public int numTrees(int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        return dp[n];
    }
}
