import java.util.Arrays;
import java.util.Comparator;

public class Question056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][2];
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        int idx = 0;
        for (int[] interval : intervals) {
            int endBefore = result[idx][1];
            int startAfter = interval[0];
            if (startAfter > endBefore) {
                idx++;
                result[idx][0] = interval[0];
            }
            result[idx][1] = Math.max(interval[1], result[idx][1]);
        }
        return Arrays.copyOf(result, idx + 1);
    }
}
