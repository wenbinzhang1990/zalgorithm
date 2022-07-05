package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    dfs(result, 0, 0, new StringBuilder(), n);
    return result;
  }

  private void dfs(List<String> result, int left, int right, StringBuilder sb, int n) {
    if (sb.length() == n * 2) {
      result.add(sb.toString());
      return;
    }

    if (left < n) {
      dfs(result, left + 1, right, sb.append("("), n);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (left > right) {
      dfs(result, left, right + 1, sb.append(")"), n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
