package com.wenbin.logic.recursion;

/**
 * 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

  long pre = Long.MIN_VALUE;

  // 比较
  public boolean isValidBSTByCompare(TreeNode root) {
    if (root == null) {
      return true;
    }

    return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  // 中序遍历为升序比较
  public boolean isValidBSTByDfsInOrder(TreeNode root) {
    if (root == null) {
      return true;
    }

    return dfs(root);
  }

  private boolean dfs(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (!dfs(root.left)) {
      return false;
    }

    if (pre >= root.val) {
      return false;
    }

    pre = root.val;
    return dfs(root.right);
  }

  private boolean dfs(TreeNode root, long low, long high) {
    if (root == null) {
      return true;
    }

    if (root.val >= high || root.val <= low) {
      return false;
    }

    return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
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
