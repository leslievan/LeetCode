import java.util.Arrays;
import java.util.Comparator;

public class Question057 {

    public static void main(String[] args) {
        Question057 question057 = new Question057();
        question057.insert(new int[][]{{0, 1}}, new int[]{0, 1});
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[newIntervals.length - 1] = newInterval;
        return merge(newIntervals);
    }

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
