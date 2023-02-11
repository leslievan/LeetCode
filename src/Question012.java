import java.util.HashMap;
import java.util.Map;

public class Question012 {
    public String intToRoman(int num) {
        String[] s1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] s2 = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] s3 = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] s4 = {"M", "MM", "MMM"};
        StringBuilder builder = new StringBuilder();
        if (num / 1000 > 0) {
            builder.append(s4[num / 1000 - 1]);
            num %= 1000;
        }
        if (num / 100 > 0) {
            builder.append(s3[num / 100 - 1]);
            num %= 100;
        }
        if (num / 10 > 0) {
            builder.append(s2[num / 10 - 1]);
            num %= 10;
        }
        if (num > 0) {
            builder.append(s1[num - 1]);
        }
        return builder.toString();
    }
}
