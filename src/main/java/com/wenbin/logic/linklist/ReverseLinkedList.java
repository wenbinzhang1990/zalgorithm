package com.wenbin.logic.linklist;

/**
 * 反转列表 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode head=new ListNode(1);
    ListNode head2=new ListNode(2);
    ListNode head3=new ListNode(3);
    ListNode head4=new ListNode(4);
    ReverseLinkedList reverseLinkedList=new ReverseLinkedList();
    head.next=head2;
    head2.next=head3;
    head3.next=head4;
    reverseLinkedList.reverseListForRecursion(head);
  }

  // 反转列表-递归
  public ListNode reverseListForRecursion(ListNode head) {
    while (head == null || head.next == null) {
      return head;
    }

    ListNode p = reverseListForRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

  // 反转列表-迭代
  public ListNode reverseListForIteration(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }

    return pre;
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
