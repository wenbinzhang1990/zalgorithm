package com.wenbin.logic.array;

/**
 * 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
 */
public class DesignCircularDequeByArray {

  int size;
  int capacity;
  int front;
  int end;
  int[] array;

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public DesignCircularDequeByArray(int k) {
    this.size = 0;
    this.capacity = k;
    this.front = 0;
    this.end = 1;
    array = new int[k];
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }

    array[front] = value;
    front = (front - 1 + capacity) % capacity;
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

    array[end] = value;
    end = (end + 1 + capacity) % capacity;
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

    front = (front + 1 + capacity) % capacity;
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

    end = (end - 1 + capacity) % capacity;
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

    return array[(front + 1 + capacity) % capacity];
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }

    return array[(end - 1 + capacity) % capacity];
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
}
