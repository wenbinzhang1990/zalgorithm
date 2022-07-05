package com.wenbin.logic.tree;

import com.wenbin.logic.tree.BinaryTreePostorderTraversal.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

  public static void main(String[] args) {
    BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode5;
    treeNode2.left = treeNode3;
    treeNode2.right = treeNode4;
    treeNode5.left = treeNode6;
    treeNode5.right = treeNode7;
    List<Integer> result = binaryTreeInorderTraversal.inorderTraversalByRecursion(treeNode1);
    System.out.println(result.toString());
  }

  /**
   * 二叉树中序遍历-递归
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversalByRecursion(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    reversal(root, result);
    return result;
  }

  /**
   * 二叉树中序遍历-迭代
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversalByIteration(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    Map<TreeNode, Boolean> map = new HashMap<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      if ((root.left == null && root.right == null) || map.containsKey(root)) {
        result.add(root.val);
        continue;
      }

      if (root.right != null) {
        stack.push(root.right);
      }

      map.put(root, true);
      stack.push(root);
      if (root.left != null) {
        stack.push(root.left);
      }
    }

    return result;
  }

  private void reversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    reversal(root.left, list);
    list.add(root.val);
    reversal(root.right, list);
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
