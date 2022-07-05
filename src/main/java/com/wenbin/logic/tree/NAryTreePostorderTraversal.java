package com.wenbin.logic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * N叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal {

  // 后序遍历 -递归
  public List<Integer> postorderByRecursion(Node root) {
    List<Integer> result = new ArrayList<>();
    reversal(result, root);
    return result;
  }

  // 后序遍历 -迭代
  public List<Integer> postorderByIteration(Node root) {
    List<Integer> result = new ArrayList<>(16);
    if (root == null) {
      return result;
    }

    Stack<Node> stack = new Stack<>();
    Map<Node, Boolean> map = new HashMap<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
        if ((root.children == null || root.children.size() == 0) || map.containsKey(root)) {
          result.add(root.val);
          continue;
        }

      map.put(root, true);
      stack.push(root);
      for (int i = root.children.size() - 1; i >= 0; i--) {
        stack.push(root.children.get(i));
      }
    }
    return result;
  }

  private void reversal(List<Integer> list, Node node) {
    if (node == null) {
      return;
    }

    for (Node child : node.children) {
      reversal(list, child);
    }

    list.add(node.val);
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
