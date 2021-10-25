package medium._102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<List<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    TreeNode rootRightLeftNode = new TreeNode(15, null, null);
    TreeNode rootRightRightNode = new TreeNode(7, null, null);

    TreeNode rootLeftNode = new TreeNode(9, null, null);
    TreeNode rootRightNode = new TreeNode(20, rootRightLeftNode, rootRightRightNode);

    TreeNode rootNode = new TreeNode(3, rootLeftNode, rootRightNode);
    Solution solution = new Solution();

    System.out.println(solution.levelOrder(rootNode));
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    travel(root, 0);
    return result;
  }

  private void travel(TreeNode currentNode, int level) {
    // exit
    if(currentNode == null) {
      return;
    }

    // logic
    if(result.size() == level) {
      List<Integer> levelNodes = new ArrayList<>();
    }
    List<Integer> levelNodes  = result.get(level);
    levelNodes.add(currentNode.val);
    result.add(levelNodes);

    // recursion, left -> right
    travel(currentNode.left, level + 1);
    travel(currentNode.right, level + 1);
  }
}
