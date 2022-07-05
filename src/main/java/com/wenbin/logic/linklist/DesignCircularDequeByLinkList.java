package com.wenbin.logic.linklist;

/**
 * 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
 */
public class DesignCircularDequeByLinkList {

  int size;
  int capacity;
  ListNode head;
  ListNode tail;

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public DesignCircularDequeByLinkList(int k) {
    this.size = 0;
    this.capacity = k;
    head = new ListNode(-1);
    tail = new ListNode(-1);
    head.next = tail;
    tail.pre = head;
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }

    insertFirst(new ListNode(value));
    size++;
    return true;
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }

    insertLast(new ListNode(value));
    size++;
    return true;
  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }

    deleteFirst();
    size--;
    return true;
  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }

    deleteLastNode();
    size--;
    return true;
  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }

    return head.next.val;
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }

    return tail.pre.val;
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return size == capacity;
  }

  /**
   * Insert first node
   *
   * @param listNode
   */
  private void insertFirst(ListNode listNode) {
    ListNode first = head.next;
    head.next = listNode;
    listNode.pre = head;
    listNode.next = first;
    first.pre = listNode;
  }

  /**
   * Insert last node
   *
   * @param listNode
   */
  private void insertLast(ListNode listNode) {
    ListNode last = tail.pre;
    last.next = listNode;
    listNode.pre = last;
    listNode.next = tail;
    tail.pre = listNode;
  }

  /**
   * delete first node
   */
  private void deleteFirst() {
    ListNode secondNode = head.next.next;
    head.next = secondNode;
    secondNode.pre = head;
  }

  /**
   * delete last node
   */
  private void deleteLastNode() {
    ListNode lastTwoNode = tail.pre.pre;
    lastTwoNode.next = tail;
    tail.pre = lastTwoNode;
  }

  class ListNode {

    int val;
    ListNode pre;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}