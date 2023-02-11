import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question001 {
    class Number {
        int value;
        int idx;

        public Number(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<Number> numberList = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            numberList.add(new Number(nums[i], i));
        }
        numberList.sort(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        int i = 0, j = numberList.size() - 1;
        while (i < numberList.size()) {
            int remainder = target - numberList.get(i).value;
            while (numberList.get(j).value > remainder) {
                j--;
            }
            if (numberList.get(j).value == remainder) {
                break;
            }
            ++i;
        }
        int[] result = {numberList.get(i).idx, numberList.get(j).idx};
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        Question001 result = new Question001();
        for (int i : result.twoSum(nums, 6)) {
            System.out.println(i);
        }
    }
}
