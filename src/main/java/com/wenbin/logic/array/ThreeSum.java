package com.wenbin.logic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList();
    int target = 0;
    Arrays.sort(nums);
    for (int first = 0; first < nums.length - 2; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }

      int third = nums.length - 1;
      int second = first + 1;
      while (second < third) {
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          second++;
          continue;
        }

        if (third < nums.length - 1 && nums[third] == nums[third + 1]) {
          third--;
          continue;
        }

        if (nums[first] + nums[second] + nums[third] == target) {
          result.add(Arrays.asList(nums[first], nums[second], nums[third]));
          second++;
          third--;
        } else if (nums[first] + nums[second] + nums[third] > 0) {
          third--;
        } else {
          second++;
        }
      }
    }

    return result;
  }
}
