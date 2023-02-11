import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Question354 {

    public static void main(String[] args) {
        Question354 question354 = new Question354();
        System.out.println(question354.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return -Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            heights[i] = envelopes[envelopes.length - i - 1][1];
        }

        for (int height : heights) {
            int loc = Arrays.binarySearch(dp, height);
            if (loc < 0) {
                loc = -loc - 1;
            }
            dp[loc] = height;
        }

        int count = 0;
        for (int i : dp) {
            if (i < Integer.MAX_VALUE) {
                count++;
            }
        }

        return count;
    }
}
