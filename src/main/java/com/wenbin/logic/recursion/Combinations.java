package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合 https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

  List<Integer> list = new ArrayList<>();
  List<List<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    Combinations combinations = new Combinations();
    combinations.combine(4, 2);
  }

  public List<List<Integer>> combine(int n, int k) {
    if (k == 0 || n < k) {
      return null;
    }

    dfs(n, k, 1);
    return result;
  }

  private void dfs(int n, int k, int count) {
    if (count > n + 1) {
      return;
    }

    if (list.size() == k) {
      result.add(new ArrayList<>(list));
      return;
    }

    // 考虑选择当前位置
    list.add(count);
    dfs(n, k, count + 1);
    list.remove(list.size() - 1);
    // 考虑不选择当前位置
    dfs(n, k, count + 1);
  }

  private void dfs2(int n, int k, int count) {
    if (count > n + 1) {
      return;
    }

    if (list.size() == k) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = count; i <= n; i++) {
      list.add(i);
      dfs(n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
