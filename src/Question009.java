public class Question009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int remainder = 0, current = x;
        while (current > 0) {
            remainder = remainder * 10 + current % 10;
            current /= 10;
        }
        return remainder == x;
    }
}
