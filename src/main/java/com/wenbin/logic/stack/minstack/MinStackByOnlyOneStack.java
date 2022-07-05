package com.wenbin.logic.stack.minstack;

import java.util.Stack;

/**
 * 最小栈(仅用一个栈) https://leetcode-cn.com/problems/min-stack/
 */
public class MinStackByOnlyOneStack {
  Stack<Integer> stack;
  int min;
  /** initialize your data structure here. */
  public MinStackByOnlyOneStack() {
    stack=new Stack();
    min=Integer.MAX_VALUE;
  }

  public void push(int x) {
    if(x<=min)
    {
      stack.push(min);
      min=x;
    }

    stack.push(x);
  }

  public void pop() {
    if(stack.pop()==min)
    {
      min=stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
