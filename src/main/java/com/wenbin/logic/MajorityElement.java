package com.wenbin.logic;

import java.util.Arrays;
import java.util.Map;

/**
 * 多数元素 https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
