package com.wenbin.logic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);
    TreeNode treeNode8 = new TreeNode(8);
    TreeNode treeNode9 = new TreeNode(9);
    TreeNode treeNode10 = new TreeNode(10);
    TreeNode treeNode11 = new TreeNode(11);
    TreeNode treeNode12 = new TreeNode(12);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode3.left = treeNode6;
    treeNode3.right = treeNode7;
    treeNode4.left = treeNode8;
    treeNode4.right = treeNode9;
    treeNode5.left = treeNode10;
    treeNode5.right = treeNode11;
    treeNode6.left = treeNode12;
    System.out.println(binaryTreeLevelOrderTraversal.levelOrderByQueue(treeNode1));
  }

  // 迭代
  public List<List<Integer>> levelOrderByQueue(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = queue.poll();
        list.add(treeNode.val);
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }

        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }

      result.add(list);
    }

    return result;
  }

  //层序遍历 map+递归
  public List<List<Integer>> levelOrderByMap(TreeNode root) {
    List<List<Integer>> result = new ArrayList();
    Map<Integer, List<Integer>> map = new HashMap();
    reversal(root, map, 0);
    result.addAll(map.values());
    return result;

  }

  private void reversal(TreeNode root, Map<Integer, List<Integer>> map, int level) {
    if (root == null) {
      return;
    }

    if (!map.containsKey(level)) {
      map.put(level, new ArrayList<>());
    }

    map.get(level).add(root.val);
    level++;
    reversal(root.left, map, level);
    reversal(root.right, map, level);
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
