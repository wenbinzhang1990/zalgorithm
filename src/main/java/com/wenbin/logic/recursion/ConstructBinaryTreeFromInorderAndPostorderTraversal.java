package com.wenbin.logic.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 从中序与后序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  // 递归
  public TreeNode buildTreeByRecursion(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length == 0
        || inorder.length != postorder.length) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
  }

  // 迭代
  public TreeNode buildTreeByIteration(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length == 0
        || inorder.length != postorder.length) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    int inOrderIndex = inorder.length - 1;
    for (int i = postorder.length - 2; i >= 0; i--) {
      TreeNode treeNode=stack.peek();
      if(treeNode.val!=inorder[inOrderIndex])
      {
        treeNode.right=new TreeNode(postorder[i]);
        stack.push(treeNode.right);
        continue;
      }

      while(!stack.isEmpty()&&inorder[inOrderIndex]==stack.peek().val)
      {
        treeNode=stack.pop();
        inOrderIndex--;
      }

      treeNode.left=new TreeNode(postorder[i]);
      stack.push(treeNode.left);
    }

    return root;
  }

  private TreeNode dfs(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft,
      int postRight, Map<Integer, Integer> map) {
    if (inLeft > inRight || postLeft > postRight) {
      return null;
    }

    TreeNode node = new TreeNode(postorder[postRight]);
    int leftLength = map.get(postorder[postRight]) - inLeft;
    node.left = dfs(inorder, postorder, inLeft, inLeft + leftLength, postLeft,
        postLeft + leftLength - 1, map);
    node.right = dfs(inorder, postorder, inLeft + leftLength + 1, inRight, postLeft + leftLength,
        postRight - 1, map);
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
