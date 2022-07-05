package com.wenbin.logic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

  public static void main(String[] args) {
    BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
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
    List<Integer> result = binaryTreePostorderTraversal.postorderTraversalByRecursion(treeNode1);
    System.out.println(result.toString());
  }

  // 二叉树后序遍历 - 递归
  public List<Integer> postorderTraversalByRecursion(TreeNode root) {
    List<Integer> list = new ArrayList();
    traversal(list, root);
    return list;
  }

  // 二叉树后序遍历 - 迭代
  public List<Integer> postorderTraversalByIteration(TreeNode root) {
    List<Integer> list = new ArrayList();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack();
    Map<TreeNode, Boolean> map = new HashMap<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      if ((root.left == null && root.right == null) || map.containsKey(root)) {
        list.add(root.val);
        continue;
      }

      map.put(root, true);
      stack.push(root);
      if (root.right != null) {
        stack.push(root.right);
      }

      if (root.left != null) {
        stack.push(root.left);
      }
    }

    return list;
  }


  public void traversal(List<Integer> list, TreeNode root) {
    if (root == null) {
      return;
    }

    traversal(list, root.left);
    traversal(list, root.right);
    list.add(root.val);

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
