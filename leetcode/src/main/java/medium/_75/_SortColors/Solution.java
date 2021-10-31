package medium._75._SortColors;

public class Solution {
  public void sortColors(int[] nums) {
    int index = 0;
    int start = 0;
    int end = nums.length-1;

    while (index <= end) {
      if (nums[index] == 0) {
        swap (nums, index++, start++);   // 앞에 있는 값을 Swap 했기 때문에 index 를 한 칸 이동한다.
        continue;
      }

      if (nums[index] == 2) {
        swap (nums, index, end--);       // 뒤에 있는 값을 Swap 했기 때문에 한번 더 탐색을 한다.
        continue;
      }

      if (nums[index] == 1) {
        index++;
      }
    }
  }

  private void swap (int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
