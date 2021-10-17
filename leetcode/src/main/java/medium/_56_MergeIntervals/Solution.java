package medium._56_MergeIntervals;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<Integer> interval = new ArrayList<>();
        List<List<Integer>> intervalList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int[] eleement : intervals) {
            interval.add(eleement[0]);
            interval.add(eleement[1]);
            intervalList.add(interval);
        }

        for (int index = 1; index < intervalList.size(); index++) {
            List<Integer> a = intervalList.get(index - 1);
            List<Integer> b = intervalList.get(index);

            if (a.get(1) >= b.get(0) && b.get(1) >= a.get(0)) {
                Integer start = b.get(0);
                Integer end = b.get(1);

                start = Math.min(a.get(0), start);
                end = Math.max(a.get(1), end);

                b.clear();
                b.add(start);
                b.add(end);

                continue;
            }

            result.add(a);
        }


        int[][] ints = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return ints;

    }
}
