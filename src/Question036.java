import java.util.HashMap;
import java.util.Map;

public class Question036 {

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] mat = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '1']++;
                    col[j][board[i][j] - '1']++;
                    mat[i / 3][j / 3][board[i][j] - '1']++;
                    if (row[i][board[i][j] - '1'] > 1 || col[j][board[i][j] - '1'] > 1
                            || mat[i / 3][j / 3][board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean validate(char[] numbers) {
        Map<Character, Integer> map = new HashMap<>();
        for (char number : numbers) {
            map.merge(number, 1, Integer::sum);
        }
        map.remove('.');
        for (Integer value : map.values()) {
            if (value > 1) {
                return false;
            }
        }
        return true;
    }
}
