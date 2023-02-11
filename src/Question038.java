import java.util.ArrayList;
import java.util.List;

public class Question038 {

    List<String> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Question038 question038 = new Question038();
        question038.countAndSay(30);
    }

    public String countAndSay(int n) {
        numbers.add("1");
        if (numbers.size() < n) { // 已有结果
            // 从最后一个开始算
            while (numbers.size() < n) {
                char[] chars = numbers.get(numbers.size() - 1).toCharArray();
                StringBuilder builder = new StringBuilder();
                int count = 0;
                int value = chars[0];
                for (char aChar : chars) {
                    if (aChar != value) {
                        builder.append(count).append(value - '0'); // 收集数字
                        count = 1;
                        value = aChar;
                    } else {
                        count++;
                    }
                }
                builder.append(count).append(value - '0');
                numbers.add(builder.toString());
            }
        }
        return numbers.get(n - 1);
    }
}
