package com.wenbin.logic.bfsanddfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值 https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class FindLargestValueInEachTreeRow {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        root = q.poll();
        max = Math.max(max, root.val);
        if (root.left != null) {
          q.add(root.left);
        }

        if (root.right != null) {
          q.add(root.right);
        }
      }

      result.add(max);
    }

    return result;
  }


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
