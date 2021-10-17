package medium._46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    /*
    * Call Stack Example, inout: 1,2,3
    * call 0: add 1                // tmp = 1
    * call 1: skip: [1], add 1,2   // tmp = 1,2
    * call 2: skip: [1,2], add 3   // tmp = 1,2,3
    * call 3: base case, tmp(1,2,3) -> add to result
    * call 2: remove 3, return     // tmp = 1,2
    * call 1: remove 2, add 3      // tmp = 1,3
    * call 4: skip: 1, add 2       // tmp = 1,3,2
    * call 5: base case, tmp(1,3,2) -> add to result
    * call 4: remove 2, skip 3     // tmp = 2,1,3
    * */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        backTrack(nums, result, tmp);
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        // base case
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        // recursion
        for (int num : nums) {
            if (tmp.contains(num)) {
                continue;
            }

            tmp.add(num);
            backTrack(nums, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
