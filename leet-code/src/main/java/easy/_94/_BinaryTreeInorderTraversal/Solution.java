package easy._94._BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {

        result = new ArrayList<>();
        traverse(root);
        return result;
    

    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);
        result.add(node.val);
        traverse(node.right);

    }

}
