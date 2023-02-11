public class Question059 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] map = new boolean[n][n];
        int state = 0;
        int i = 0, j = 0;
        int count = 1;
        while (i >= 0 && i < n && j >= 0 && j < n && !map[i][j]) {
            matrix[i][j] = count++;
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
                    if (i >= n || map[i][j]) {
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
        return matrix;
    }
}
