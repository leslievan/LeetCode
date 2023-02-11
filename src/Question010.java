import java.util.List;

public class Question010 {

    public static void main(String[] args) {
        Question010 question010 = new Question010();
        System.out.println(question010.isMatch("aaa", "a*a"));

    }

    public boolean isMatch(String s, String p) {
        int i = 0, j = i + 1;
        char[][] token = new char[30][2];
        int size = 0;
        while (i < p.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                token[size++] = new char[]{1, p.charAt(i)};
                i += 2;
            } else {
                if (size - 1 < 0 || token[size - 1][0] != 1 || token[size - 1][1] != p.charAt(i)) {
                    token[size++] = new char[]{0, p.charAt(i)};
                }
                i++;
            }
            j = i + 1;
        }

        int idx = 0;
        for (int k = 0; k < size; ++k) {
            if (token[k][0] == 0) {
                if (idx == s.length()) {
                    return false;
                }
                idx = processSingleChar(s, token[k][1], idx);
            } else {
                idx = processDoubleChar(s, token[k][1], idx);
            }
        }
        return idx == s.length();
    }

    int processSingleChar(String s, char ch, int idx) {
        if (idx == s.length()) {
            return idx;
        }
        if (ch != '.' && s.charAt(idx) != ch) {
            return idx;
        }
        return ++idx;
    }

    int processDoubleChar(String s, char ch, int idx) {
        int newIdx = idx - 1;
        while (idx < s.length() && idx != newIdx) {
            newIdx = idx;
            idx = processSingleChar(s, ch, idx);
        }
        return idx;
    }
}
