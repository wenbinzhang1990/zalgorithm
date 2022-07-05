package com.wenbin.logic.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap();
    Stack<Character> stack = new Stack();
    map.put('}', '{');
    map.put(']', '[');
    map.put(')', '(');
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        if (stack.isEmpty()) {
          return false;
        }

        if (!stack.pop().equals(map.get(s.charAt(i)))) {
          return false;
        }
      } else {
        stack.push(s.charAt(i));
      }
    }

    return stack.isEmpty();
  }
}
