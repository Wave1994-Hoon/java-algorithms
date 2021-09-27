package easy._938_RangeSumOfBST;

public class Solution {
    /*
    * 0. root == null return 0;
    * 1. root.val < L  --> 오른쪽 서브르티만 탐색
    * 2. root.val > R  --> 왼쪽 서브트리만 탐색
    * 3. L <= root.val <= R --> 왼쪽 서브트리 + 네 값 + 오른쪽 서브트리
    *
    * */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (low <= root.val && root.val<= high) {
            return rangeSumBST(root.left, low, high) + root.val +rangeSumBST(root.right,low, high);
        }
        throw new IllegalArgumentException();
    }
}
