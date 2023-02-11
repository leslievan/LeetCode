import java.util.Arrays;

public class Question073 {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[201];
        boolean[] columns = new boolean[201];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (rows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (columns[i]) {
                for (int j = 0; j < matrix.length; ++i) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
