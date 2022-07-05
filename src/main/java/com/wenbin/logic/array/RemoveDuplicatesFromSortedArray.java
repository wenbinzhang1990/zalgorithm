package com.wenbin.logic.array;

/**
 * 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int cur = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[cur]) {
        nums[++cur] = nums[i];
      }
    }

    return cur + 1;
  }
}
