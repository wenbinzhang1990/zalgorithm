package com.wenbin.logic.recursion;

/**
 * 二叉树的最小深度  https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = minDepth(root.left);
    int right = minDepth(root.right);
    //如果left和right都为0，我们返回1即可，
    //如果left和right只有一个为0，说明他只有一个子结点，我们只需要返回它另一个子节点的最小深度+1即可。
    //如果left和right都不为0，说明他有两个子节点，我们只需要返回最小深度的+1即可。
    return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
