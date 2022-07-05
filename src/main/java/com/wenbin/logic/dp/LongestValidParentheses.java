package com.wenbin.logic.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号 https://leetcode-cn.com/problems/longest-valid-parentheses
 */
public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    if (s.length() <= 1) {
      return 0;
    }

    int max = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }

        max = Math.max(max, dp[i]);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
    longestValidParentheses.longestValidParenthesesByStack("))))))");
  }

  public int longestValidParenthesesByStack(String s) {
    if (s.length() <= 1) {
      return 0;
    }

    int maxans = 0;
    Deque<Integer> stack = new LinkedList<Integer>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maxans = Math.max(maxans, i - stack.peek());
        }
      }
    }
    return maxans;
  }
}

