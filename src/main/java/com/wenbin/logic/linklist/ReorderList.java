package com.wenbin.logic.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表 https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {

  public static void main(String[] args) {
    ReorderList reorderList = new ReorderList();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

  }

  public void reorderListByArray(ListNode head) {
    if (head == null) {
      return;
    }

    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }

    int i = 0;
    int j = list.size() - 1;
    while (i < j) {
      list.get(i).next = list.get(j);
      i++;

      if (i == j) {
        break;
      }

      list.get(j).next = list.get(i);
      j--;
    }

    list.get(i).next = null;
  }

  public void reorderListByRevert(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode mid = middleNode(head);
    ListNode l1 = head;
    ListNode l2 = mid.next;
    mid.next = null;
    l2 = reverseList(l2);
    mergeList(l1, l2);
  }

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  public void mergeList(ListNode l1, ListNode l2) {
    ListNode l1_tmp;
    ListNode l2_tmp;
    while (l1 != null && l2 != null) {
      l1_tmp = l1.next;
      l2_tmp = l2.next;

      l1.next = l2;
      l1 = l1_tmp;

      l2.next = l1;
      l2 = l2_tmp;
    }
  }


  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
