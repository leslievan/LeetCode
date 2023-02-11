public class Question062 {

    int count = 0;

    public static void main(String[] args) {
        Question062 question062 = new Question062();
        question062.uniquePaths(3, 2);
    }

    int[][] memo = new int[101][101];
    public int uniquePaths(int m, int n) {
        for (int i = 0; i < 101; i++) {
            memo[i][1] = 1;
            memo[1][i] = 1;
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m][n];
    }
}
