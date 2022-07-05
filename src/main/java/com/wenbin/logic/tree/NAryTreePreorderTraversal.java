package com.wenbin.logic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryTreePreorderTraversal {

  // 前序遍历-递归
  public List<Integer> preorderByRecursion(Node root) {
    List<Integer> result = new ArrayList<>();
    front(result, root);
    return result;
  }

  // 前序遍历-迭代
  public List<Integer> preorderByIteration(Node root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<Node> stack = new Stack<>();
    Map<Node, Boolean> map = new HashMap<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      result.add(root.val);
      for (int i=root.children.size()-1;i>=0;i--) {
        if (root.children.get(i)!= null) {
          stack.push(root.children.get(i));
        }
      }
    }
    return result;
  }

  public void front(List<Integer> list, Node node) {
    if (node == null) {
      return;
    }

    list.add(node.val);
    for (Node child : node.children) {
      front(list, child);
    }
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
