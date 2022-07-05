package com.wenbin.logic.linklist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }

    int left = 0, right = list.size() - 1;
    while (left < right) {
      if (list.get(left++).val != list.get(right--).val) {
        return false;
      }
    }

    return true;
  }

  public boolean isPalindromeByFastAndSLow(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode pre = null;
    while (slow != null) {
      ListNode next = slow.next;
      slow.next = pre;
      pre = slow;
      slow = next;
    }

    while (pre != null) {
      if (pre.val != head.val) {
        return false;
      }

      pre = pre.next;
      head = head.next;
    }

    return true;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
