package medium._75._SortColors;

public class Solution {
  public void sortColors(int[] nums) {

    int i = 0;
    int j = nums.length-1;
    int k = 0;

    while (k <= j) {
      if (nums[k] == 0) {
        swap (nums, i++, k++);
        continue;
      }

      if (nums[k] == 2) {
        swap (nums, k, j--);
        continue;
      }

      k++;
    }
  }

  private void swap (int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
