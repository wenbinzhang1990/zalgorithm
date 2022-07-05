package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndSerializeBinaryTree {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode3.left = treeNode4;
    treeNode3.right = treeNode5;
//    treeNode3.left = treeNode6;
//    treeNode3.right = treeNode7;

    SerializeAndSerializeBinaryTree serializeAndSerializeBinaryTree = new SerializeAndSerializeBinaryTree();
    String s = serializeAndSerializeBinaryTree.serialize(treeNode1);
    TreeNode a = serializeAndSerializeBinaryTree.deserialize(s);
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      root = queue.poll();
      if (root == null) {
        list.add(null);
        continue;
      }

      list.add(String.valueOf(root.val));
      queue.add(root.left);
      queue.add(root.right);
    }

    return join(list, ",");
  }


  public String join(Iterable<String> pieces, String separator) {
    StringBuilder buffer = new StringBuilder();

    for (Iterator<String> iter = pieces.iterator(); iter.hasNext(); ) {
      buffer.append(iter.next());

      if (iter.hasNext()) {
        buffer.append(separator);
      }
    }

    return buffer.toString();
  }


  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }

    String[] strings = data.split(",");
    if (strings.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int count = 1;
    while (!queue.isEmpty() && count < strings.length) {
      TreeNode node = queue.poll();
      if (!strings[count].equalsIgnoreCase("null")) {
        node.left = new TreeNode(Integer.valueOf(strings[count]));
        queue.add(node.left);
      }

      count++;
      if (!strings[count].equalsIgnoreCase("null")) {
        node.right = new TreeNode(Integer.valueOf(strings[count]));
        queue.add(node.right);
      }
      count++;
    }

    return root;
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
