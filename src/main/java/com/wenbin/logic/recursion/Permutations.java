package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

  public static void main(String[] args) {
    Permutations permutations = new Permutations();
    permutations.permute(new int[]{2, 3, 4});
  }

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> list = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    dfs(nums, 0);
    return result;
  }


  private void dfs(int[] nums, int count) {
    if (count >= nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }

      list.add(nums[i]);
      dfs(nums, count + 1);
      list.remove(list.size() - 1);
    }
  }
}
