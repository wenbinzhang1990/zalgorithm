package com.wenbin.logic.array;

/**
 * 盛水最多的容器 https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left <= right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(max, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
