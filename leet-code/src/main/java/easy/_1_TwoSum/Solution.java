package easy._1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int currentNumber = nums[index];

            if (map.containsKey(target - currentNumber)) {
                int[] result = new int[2];
                result[0] = map.get(target - currentNumber);
                result[1] = index;

                return result;
            }

            map.put(currentNumber, index);

        }

        return null;
    }

}
