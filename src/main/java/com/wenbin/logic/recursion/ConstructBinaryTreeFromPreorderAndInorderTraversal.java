package com.wenbin.logic.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  // 递归
  public TreeNode buildTreeByRecursion(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null) {
      return null;
    }

    if (preorder.length == 0 || preorder.length != inorder.length) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
  }

  // 迭代
  public TreeNode buildTreeByIteration(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null) {
      return null;
    }

    if (preorder.length == 0 || preorder.length != inorder.length) {
      return null;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]);
    stack.push(root);
    int inIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (inorder[inIndex] != node.val) {
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
        continue;
      }

      while (!stack.isEmpty() && inorder[inIndex] == stack.peek().val) {
        node = stack.pop();
        inIndex++;
      }

      node.right = new TreeNode(preorderVal);
      stack.push(node.right);
    }

    return root;
  }

  private TreeNode dfs(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft,
      int inRight, Map<Integer, Integer> map) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[preLeft]);
    int leftLength = map.get(preorder[preLeft]) - inLeft;
    node.left = dfs(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft,
        inLeft + leftLength,
        map);
    node.right = dfs(preorder, preLeft + leftLength + 1, preRight, inorder, inLeft + leftLength + 1,
        inRight,
        map);

    return node;
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
