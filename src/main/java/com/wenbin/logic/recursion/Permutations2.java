package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II https://leetcode-cn.com/problems/permutations-ii/
 */
public class Permutations2 {

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> list = new ArrayList<>();
  boolean[] visited;

  public List<List<Integer>> permuteUnique(int[] nums) {
    visited = new boolean[nums.length];
    Arrays.sort(nums);
    dfs(nums);
    return result;
  }

  private void dfs(int[] nums) {
    if (list.size() >= nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }

      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
        continue;
      }

      visited[i] = true;
      list.add(nums[i]);
      dfs(nums);
      list.remove(list.size() - 1);
      visited[i] = false;
    }
  }


  public static void main(String[] args) {
    boolean[] booleans = new boolean[3];
    String a = "a";
  }
}
