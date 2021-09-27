package medium._31_NextPermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        /* 뒤에서 부터 탐색하면서 오름차순이 깨지는 인덱스 확인 (a) */
        int a = nums.length - 2;
        while (a >= 0 && nums[a] >= nums[a+1]) {
            a --;
        }

        /* 다시 뒤에서 부터 탐색하면서 a보다 큰 첫번째 인덱스를 화인 (b) */
        if (a != -1) {
            int b = nums.length -1;
            while (nums[a] >= nums[b]) {
                b --;
            }
            swap(nums, a, b); // a와 b를 스왑
        }

        /* a+1에서부터 끝까지를 오름차순으로 정렬 */
        int start = a + 1;
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start ++, end --);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
