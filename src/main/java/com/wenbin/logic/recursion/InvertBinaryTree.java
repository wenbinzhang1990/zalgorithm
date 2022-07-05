package com.wenbin.logic.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

  // Dfs
  public TreeNode invertTreeByDfs(TreeNode root) {
    dfs(root);
    return root;
  }

  // Bfs
  public TreeNode invertTreeByBfs(TreeNode root) {
    if (root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty())
    {
      TreeNode node=queue.poll();
      TreeNode temp=node.left;
      node.left=node.right;
      node.right=temp;
      if(node.left!=null)
      {
        queue.add(node.left);
      }

      if(node.right!=null)
      {
        queue.add(node.right);
      }
    }

    return root;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(node.left);
    dfs(node.right);
    TreeNode left = node.left;
    node.left = node.right;
    node.right = left;
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
