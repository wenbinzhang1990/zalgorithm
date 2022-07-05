package com.wenbin.logic.stack;

import java.util.Stack;

/**
 * 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

  // 柱状图最大矩形-暴力求解
  public int largestRectangleAreaForViolence(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int leftIndex = i;
      int rightIndex = i;
      for (int j = i - 1; j >= 0; j--) {
        if (heights[j] < heights[i]) {
          break;
        } else {
          leftIndex = j;
        }
      }

      for (int j = i + 1; j < heights.length; j++) {
        if (heights[j] < heights[i]) {
          break;
        } else {
          rightIndex = j;
        }
      }

      maxArea = Math.max(maxArea, (rightIndex - leftIndex + 1) * heights[i]);
    }

    return maxArea;
  }

  // 柱状图最大矩形-栈
  public int largestRectangleAreaForStack(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        int index = stack.pop();
        int distance = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;
        maxArea = Math.max(heights[index] * distance, maxArea);
      }

      stack.push(i);
    }

    if (stack.isEmpty()) {
      return maxArea;
    }

    int rightIndex = stack.peek();
    while (!stack.isEmpty()) {
      int curIndex = stack.pop();
      int distance = rightIndex - (stack.isEmpty() ? -1 : stack.peek());
      maxArea = Math.max(heights[curIndex] * distance, maxArea);
    }

    return maxArea;
  }

  // 柱状图最大矩形-栈（通过前面埋0优化）
  public int largestRectangleAreaForStackOptimized(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int[] newHeights = new int[heights.length + 2];
    System.arraycopy(heights, 0, newHeights, 1, heights.length);
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < newHeights.length; i++) {
      while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
        int index = stack.pop();
        int distance = i - stack.peek() - 1;
        maxArea = Math.max(newHeights[index] * distance, maxArea);
      }

      stack.push(i);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
    largestRectangleInHistogram.largestRectangleAreaForStackOptimized(new int[]{0, 1});
  }
}
