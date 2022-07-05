package com.wenbin.logic.array;

/**
 * 移动零 https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeros {

  public void moveZeroes(int[] nums) {
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[cur] = nums[i];
        if (i > cur) {
          nums[i] = 0;
        }

        cur++;
      }
    }
  }
}
