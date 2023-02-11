public class Question043 {

    public static void main(String[] args) {
        Question043 question043 = new Question043();
        question043.multiply("123", "456");
    }

    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] numStr2 = num2.toCharArray();
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder others = new StringBuilder(multiplyOneBit(num1, numStr2[i]));
            others.append("0".repeat(num2.length() - i - 1));
            result = plus(result, others.toString());
//            result = plus("990", "10");
        }
        return result;
    }

    String multiplyOneBit(String num1, char num2) {
        String result = "0";
        for (int i = 0; i < num2 - '0'; i++) {
            result = plus(result, num1);
        }
        return result;
    }

    String plus(String num1, String num2) {
        char[] numStr1 = num1.toCharArray();
        char[] numStr2 = num2.toCharArray();
        int res = 0;
        StringBuilder builder = new StringBuilder();
        int i = 1;
        while (i <= Math.min(numStr1.length, numStr2.length)) {
            int value = numStr1[numStr1.length - i] + numStr2[numStr2.length - i] + res - 2 * '0';
            res = value / 10;
            builder.append(value % 10);
            i++;
        }
        while (i <= numStr1.length) {
            int value = numStr1[numStr1.length - i] + res - '0';
            res = value / 10;
            builder.append(value % 10);
            i++;
        }
        while (i <= numStr2.length) {
            int value = numStr2[numStr2.length - i] + res - '0';
            res = value / 10;
            builder.append(value % 10);
            i++;
        }
        if (res != 0) {
            builder.append(res);
        }
        return builder.reverse().toString();
    }
}
