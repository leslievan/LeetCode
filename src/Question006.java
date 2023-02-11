import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question006 {

    public static void main(String[] args) {
        Question006 question006 = new Question006();
        System.out.println(question006.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            list.add(new StringBuffer());
        }
        int row = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); ++i) {
            if (!flag) {
                list.get(row++).append(s.charAt(i));
                if (row >= numRows) {
                    flag = true;
                    --row;
                }
            } else {
                list.get(--row).append(s.charAt(i));
                if (row <= 0) {
                    flag = false;
                    ++row;
                }
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer buffer : list) {
            ans.append(buffer);
        }
        return ans.toString();
    }
}
