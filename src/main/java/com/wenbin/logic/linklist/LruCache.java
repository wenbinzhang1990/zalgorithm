package com.wenbin.logic.linklist;

import java.util.HashMap;
import java.util.Map;


/**
 * Lru缓存 https://leetcode-cn.com/problems/lru-cache
 */
public class LruCache {

  int size;
  int capacity;
  DNode head;
  DNode tail;
  Map<Integer, DNode> map;


  public LruCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    head = new DNode(-1, -1);
    tail = new DNode(-1, -1);
    head.next = tail;
    tail.pre = head;
    map = new HashMap<>();
  }

  public int get(int key) {
    DNode dNode = map.get(key);
    if (dNode == null) {
      return -1;
    }

    if (dNode.pre != head) {
      moveToFirst(dNode);
    }

    return dNode.getVal();
  }

  public int put(int key, int value) {
    DNode dNode = map.get(key);
    if (dNode != null) {
      dNode.setVal(value);
      moveToFirst(dNode);
      return key;
    }

    if (size == capacity) {
      removeLastNode();
      size--;
    }

    size++;
    DNode newNode = new DNode(key, value);
    addFirstNode(newNode);
    return key;
  }

  private void moveToFirst(DNode dNode) {
    removeNode(dNode);
    addFirstNode(dNode);
  }

  private void removeLastNode() {
    removeNode(tail.pre);
  }

  private void addFirstNode(DNode dNode) {
    DNode first = head.next;
    head.next = dNode;
    dNode.pre = head;
    dNode.next = first;
    first.pre = dNode;
    map.put(dNode.key, dNode);
  }

  private void removeNode(DNode dNode) {
    DNode next = dNode.next;
    DNode pre = dNode.pre;
    pre.next = next;
    next.pre = pre;
    map.remove(dNode.key);
  }

  class DNode {

    int val;
    int key;

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    DNode next;
    DNode pre;

    public DNode(int key, int val) {
      this.val = val;
      this.key = key;
    }

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }
  }
}
