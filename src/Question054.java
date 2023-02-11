import java.util.ArrayList;
import java.util.List;

public class Question054 {

    public static void main(String[] args) {
        Question054 question054 = new Question054();
        question054.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] map = new boolean[matrix.length][matrix[0].length];
        int state = 0;
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i >= 0 && i < m && j >= 0 && j < n && !map[i][j]) {
            result.add(matrix[i][j]);
            map[i][j] = true;
            switch (state) {
                case 0: // right
                    j++;
                    if (j >= n || map[i][j]) {
                        j--;
                        i++;
                        state = 1;
                    }
                    break;
                case 1: // down
                    i++;
                    if (i >= m || map[i][j]) {
                        i--;
                        j--;
                        state = 2;
                    }
                    break;
                case 2: // left
                    j--;
                    if (j < 0 || map[i][j]) {
                        j++;
                        i--;
                        state = 3;
                    }
                    break;
                case 3:
                    i--;
                    if (i < 0 || map[i][j]) {
                        i++;
                        j++;
                        state = 0;
                    }
                    break;
            }
        }
        return result;
    }
}
