package com.wenbin.logic.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表 https://leetcode-cn.com/problems/linked-list-cycle https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycle {

  // 判断是否有环-map处理
  public boolean hasCycleForMap(ListNode head) {
    Map<ListNode, Boolean> map = new HashMap();
    while (head != null) {
      if (map.containsKey(head)) {
        return true;
      }

      map.put(head, true);
      head = head.next;
    }

    return false;
  }

  // 判断是否有环-快慢指针
  public boolean hasCycleForFastAndSlow(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }

    return false;
  }

  //检查环形列表起点-Map解决
  public ListNode detectCycleForMap(ListNode head) {
    Map<ListNode, Boolean> map = new HashMap();
    while (head != null) {
      if (map.containsKey(head)) {
        return head;
      }

      map.put(head, true);
      head = head.next;
    }

    return null;
  }

  //检查环形列表起点-快慢指针
  public ListNode detectCycleForFastAndSlow(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        fast = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }

        return fast;
      }
    }

    return null;
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
