import java.util.ArrayList;
import java.util.List;

public class Question089 {

    public static void main(String[] args) {
        Question089 question089 = new Question089();
        question089.grayCode(3);
    }

    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return List.of(0, 1);
        }
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for (int i = 1; i < n; i++) {
            int x = (1 << (i + 1)) - 1;
            int size = result.size();
            for (int j = 0; j < size; j++) {
                result.add(result.get(j) ^ x);
            }
        }
        return result;
    }
}
