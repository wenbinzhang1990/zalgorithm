package com.wenbin.logic.array;

/**
 * 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

  // 旋转数组-一个个移动
  public void rotateForMoveOneByOne(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      int pre = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        int temp = nums[j];
        nums[j] = pre;
        pre = temp;
      }
    }
  }

  // 旋转数组-数学方式翻转
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
}
