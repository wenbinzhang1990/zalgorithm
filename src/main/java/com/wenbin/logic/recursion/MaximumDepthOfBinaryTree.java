package com.wenbin.logic.recursion;

import java.util.logging.Level;

/**
 * 二叉树的最大深度  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return 1 + Math.max(left, right);
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
