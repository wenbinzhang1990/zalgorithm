package com.wenbin.logic.stack.minstack;

import java.util.Stack;

/**
 * 最小栈(Stack,辅助最小Stack实现) https://leetcode-cn.com/problems/min-stack/
 */
public class MinStackByStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;
  /** initialize your data structure here. */
  public MinStackByStack() {
    stack=new Stack();
    minStack=new Stack();
  }

  public void push(int x) {
    stack.push(x);
    if(!minStack.isEmpty()){
      minStack.push(minStack.peek()>x?x:minStack.peek());
    }else{
      minStack.push(x);
    }
  }

  public void pop() {
    if(stack.isEmpty())
    {
      return;
    }

    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
