package com.wenbin.logic.linklist;

/**
 * K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

  // K个一组反转链表-迭代
  public ListNode reverseKGroupForIteration(ListNode head, int k) {
    ListNode newHead = new ListNode(-1);
    newHead.next = head;
    ListNode pre = newHead;
    while (head != null) {
      ListNode tailNode = head;
      int count = 0;
      for (int i = 0; i < k; i++) {
        if (tailNode != null) {
          tailNode = tailNode.next;
          count++;
        }
      }

      if (count != k) {
        pre.next = head;
        break;
      }

      pre.next = reverse(head, tailNode);
      pre = head;
      head = tailNode;
    }

    return newHead.next;
  }

  // K个一组反转链表-递归
  public ListNode reverseKGroupForRecursion(ListNode head, int k) {
    ListNode tailNode = head;
    for (int i = 0; i < k; i++) {
      if (tailNode == null) {
        return head;
      }

      tailNode = tailNode.next;
    }

    ListNode pNode = reverse(head, tailNode);
    head.next = reverseKGroupForRecursion(tailNode, k);
    return pNode;
  }

  public ListNode reverse(ListNode headNode, ListNode tailNode) {
    ListNode pre = null;
    while (headNode != tailNode) {
      ListNode next = headNode.next;
      headNode.next = pre;
      pre = headNode;
      headNode = next;
    }

    return pre;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
