public class Question028 {

    public static void main(String[] args) {
        Question028 question028 = new Question028();
        question028.strStr("a", "a");
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] str = haystack.toCharArray();
        char[] keyword = needle.toCharArray();
        for (int i = 0; i <= str.length - keyword.length; ++i) {
            int j = 0;
            while (j < keyword.length) {
                if (str[i + j] != keyword[j]) {
                    break;
                } else {
                    j++;
                }
            }
            if (j == keyword.length) {
                return i;
            }
        }
        return -1;
    }
}
