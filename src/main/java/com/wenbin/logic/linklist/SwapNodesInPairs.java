package com.wenbin.logic.linklist;

/**
 * 两两交换列表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapNodesInPairs {

  // 两两交换列表节点-递归
  public ListNode swapPairsForRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode first = head;
    ListNode second = head.next;
    first.next = swapPairsForRecursion(second.next);
    second.next = first;
    return second;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node.next = node2;
    node.next.next = node3;
    node.next.next.next = node4;
    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
    swapNodesInPairs.swapPairsForIteration(node);
  }

  // 两两交换列表节点-迭代
  public ListNode swapPairsForIteration(ListNode head) {
    ListNode newHead = new ListNode(-1);
    newHead.next = head;
    ListNode pre = newHead;
    while (head != null && head.next != null) {
      ListNode first = head;
      ListNode second = head.next;

      pre.next = second;
      first.next = second.next;
      second.next = first;

      pre = first;
      head = first.next;
    }

    return newHead.next;
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
