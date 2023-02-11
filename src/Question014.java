public class Question014 {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int length = 255;
        for (String str : strs) {
            length = Math.min(str.length(), length);
        }
        for (i = 0; i < length; ++i) {
            char currentCh = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != currentCh) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
