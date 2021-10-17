package medium._98_ValidateBinarySearchTree;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, false, false, 0, 0); // init
    }

    private boolean isValidBST(
            TreeNode root,
            boolean lowerBoundExist,
            boolean upperBoundExist,
            int lowerBound,
            int upperBound
    ) {
        if (root == null) {
            return true;
        }

        if (checkLowerBound(root, lowerBoundExist, lowerBound)) {
            return false;
        }

        if (checkUpperBound(root, upperBoundExist, upperBound)) {
            return false;
        }

        return isValidEntireBST(root, lowerBoundExist, upperBoundExist, lowerBound, upperBound);

    }

    private boolean isValidEntireBST(TreeNode root, boolean lowerBoundExist, boolean upperBoundExist, int lowerBound, int upperBound) {
        return isValidBST(root.left, lowerBoundExist, true, lowerBound, root.val)
                && isValidBST(root.right, true, upperBoundExist, root.val, upperBound);
    }

    private boolean checkUpperBound(TreeNode root, boolean upperBoundExist, int upperBound) {
        return upperBoundExist && root.val >= upperBound;
    }

    private boolean checkLowerBound(TreeNode root, boolean lowerBoundExist, int lowerBound) {
        return lowerBoundExist && root.val <= lowerBound;
    }
}