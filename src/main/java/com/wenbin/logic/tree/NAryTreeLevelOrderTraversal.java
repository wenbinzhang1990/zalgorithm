package com.wenbin.logic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList();
    if (root == null) {
      return result;
    }

    Queue<Node> queue = new LinkedList();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        root = queue.poll();
        list.add(root.val);
        queue.addAll(root.children);
      }

      result.add(list);
    }

    return result;
  }

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }


}
