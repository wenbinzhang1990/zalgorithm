package com.wenbin.logic.tree;

import com.wenbin.logic.tree.BinaryTreeLevelOrderTraversal.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

  public static void main(String[] args) {
    String[][] a=new String[5][5];
    BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
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
    List<Integer> result = binaryTreePreorderTraversal.preorderTraversalByRecursion(treeNode1);
    System.out.println(result.toString());
  }

  /**
   * 二叉树前序遍历-递归
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByRecursion(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    reversal(root, list);
    return list;
  }

  /**
   * 二叉树前序遍历-迭代
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByIteration(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      list.add(root.val);
      if (root.right != null) {
        stack.push(root.right);
      }

      if (root.left != null) {
        stack.push(root.left);
      }
    }

    return list;
  }

  /**
   * 二叉树前序遍历-迭代（与中后序保持一致）
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByIterationUnion(
      BinaryTreeLevelOrderTraversal.TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<BinaryTreeLevelOrderTraversal.TreeNode> stack = new Stack<>();
    Map<BinaryTreeLevelOrderTraversal.TreeNode, Boolean> map = new HashMap<>();
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

      if (root.left != null) {
        stack.push(root.left);
      }

      map.put(root, true);
      result.add(root.val);
    }

    return result;
  }

  private void reversal(TreeNode treeNode, List<Integer> list) {
    if (treeNode == null) {
      return;
    }

    list.add(treeNode.val);
    reversal(treeNode.left, list);
    reversal(treeNode.right, list);
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
