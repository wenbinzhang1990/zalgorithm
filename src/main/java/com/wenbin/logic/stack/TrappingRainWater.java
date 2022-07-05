package com.wenbin.logic.stack;

import java.util.Stack;

/**
 * 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

  //暴力求解
  public int trapForIteration(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int result = 0;
    for (int i = 0; i < height.length; i++) {
      int maxLeft = i;
      int maxRight = i;
      for (int j = 0; j < i; j++) {
        maxLeft = height[j] > height[maxLeft] ? j : maxLeft;
      }

      for (int j = height.length - 1; j > i; j--) {
        maxRight = height[j] > height[maxRight] ? j : maxRight;
      }

      result += Math.min(height[maxLeft], height[maxRight]) - height[i];
    }

    return result;
  }

  //暴力求解 优化
  public int trapForIterationOptimized(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int result = 0;
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    int maxLeft = 0;
    int maxRight = height.length - 1;
    int j = height.length - 1;
    for (int i = 0; i < height.length; i++) {
      if (height[i] > height[maxLeft]) {
        maxLeft = i;
      }

      left[i] = maxLeft;
      if (height[j] > height[maxRight]) {
        maxRight = j;
      }
      right[j--] = maxRight;
    }

    for (int i = 0; i < height.length; i++) {
      result += Math.min(height[left[i]], height[right[i]]) - height[i];
    }

    return result;
  }

  //栈求解
  public int trapForStack(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        int stackValue = stack.pop();
        if (stack.isEmpty()) {
          continue;
        }

        int distance = i - stack.peek() - 1;
        result += (Math.min(height[i], height[stack.peek()]) - height[stackValue]) * distance;
      }

      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    trappingRainWater.trapForStack(new int[]{4, 2, 3});
  }
}
