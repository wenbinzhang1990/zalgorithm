package com.wenbin.logic.linklist;

/**
 * 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

  // 合并两个有序链表-递归
  public ListNode mergeTwoListsForRecursion(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = mergeTwoListsForRecursion(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListsForRecursion(l2.next, l1);
      return l2;
    }
  }

  // 合并两个有序链表-迭代
  public ListNode mergeTwoListsForIteration(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode pre = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }

      pre = pre.next;
    }

    pre.next = l1 == null ? l2 : l1;

    return head.next;
  }

  public class ListNode {

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
