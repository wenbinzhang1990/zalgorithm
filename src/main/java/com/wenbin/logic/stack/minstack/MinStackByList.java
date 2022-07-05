package com.wenbin.logic.stack.minstack;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈(List,辅助最小list实现) https://leetcode-cn.com/problems/min-stack/
 */
public class MinStackByList {

  List<Integer> list;
  List<Integer> minList;

  /**
   * initialize your data structure here.
   */
  public MinStackByList() {
    list = new ArrayList();
    minList = new ArrayList();
  }

  public void push(int x) {
    list.add(x);
    if (minList.size() == 0) {
      minList.add(x);
    } else {
      minList.add(minList.get(minList.size() - 1) > x ? x : minList.get(minList.size() - 1));
    }
  }

  public void pop() {
    if (list.size() == 0) {
      return;
    }

    list.remove(list.size() - 1);
    minList.remove(minList.size() - 1);
  }

  public int top() {
    return list.get(list.size() - 1);
  }

  public int getMin() {
    return minList.get(minList.size() - 1);
  }
}
