package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 https://leetcode-cn.com/problems/subsets/
 */
public class SubSets {

  List<Integer> t = new ArrayList<Integer>();
  List<List<Integer>> ans = new ArrayList<List<Integer>>();

  public List<List<Integer>> subsets(int[] nums) {
    recursion(nums, 0);
    return ans;
  }

  private void recursion(int[] num, int cur) {
    if (cur == num.length) {
      ans.add(new ArrayList<>(t));
      return;
    }

    t.add(num[cur]);
    recursion(num, cur + 1);
    t.remove(t.size() - 1);
    recursion(num, cur + 1);
  }
}
