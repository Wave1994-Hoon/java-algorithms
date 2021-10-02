package medium._215_KthLargestElementInAnArray;

import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
                continue;
            }

            if (num > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }

        }

        return priorityQueue.peek();
    }
}
