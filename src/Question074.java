import java.util.Arrays;

public class Question074 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while (i < m && matrix[i][n - 1] < target) {
            i++;
        }
        if (i == m) {
            return false;
        } else {
            return Arrays.binarySearch(matrix[i], target) >= 0;
        }
    }
}
