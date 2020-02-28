
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {
    public static void main(String[] args) {
        NumbersWithEqualDigitSum digitSum = new NumbersWithEqualDigitSum();
        int[] ar = new int[]{51, 71, 17, 42};

        System.out.println("the result is " + digitSum.maxSum(ar));
    }

    int maxSum(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> resMap = new HashMap<>();
        int i = 0, resSum = -1;
        while (i < arr.length) {
            int sum = getSum(arr[i]);
            if (resMap.containsKey(sum)) {
                resMap.get(sum).add(arr[i]);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                resMap.put(sum, tmp);
            }
            i++;
        }

        for (Map.Entry<Integer, ArrayList<Integer>> map : resMap.entrySet()) {

            if (map.getValue().size() >= 2) {
                ArrayList<Integer> tmp1 = map.getValue();
                Collections.sort(tmp1, Collections.reverseOrder());
                if (tmp1.get(0) + tmp1.get(1) > resSum) {
                    resSum = tmp1.get(0) + tmp1.get(1);
                }
            }
        }
        return resSum;
    }

    int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
} // Worst time complexity O(n) and Worst space complexity is O(n)
