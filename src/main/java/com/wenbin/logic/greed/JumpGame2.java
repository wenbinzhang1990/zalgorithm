package com.wenbin.logic.greed;

/**
 * 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGame2 {

  public int jump(int[] nums) {
    int max = 0;
    int end = 0;
    int step = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      max = Math.max(max, i + nums[i]);
      if (i == end) {
        end = max;
        step++;
      }
    }

    return step;
  }
}
