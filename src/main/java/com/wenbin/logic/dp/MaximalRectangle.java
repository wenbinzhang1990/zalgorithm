package com.wenbin.logic.dp;

import java.util.Stack;

/**
 * 最大矩形 https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] dp = new int[rowCount][colCount + 1];
        int maxArea = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                if (matrix[i][j - 1] == '1') {
                    dp[i][j] = dp[i][j - 1] + 1;
                    int minWidth = Integer.MAX_VALUE;
                    for (int k = i; k >= 0; k--) {
                        minWidth = Math.min(minWidth, dp[k][j]);
                        maxArea = Math.max(maxArea, minWidth * (i - k + 1));
                    }
                }
            }
        }

        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }

            maxarea = Math.max(maxarea, largestRectangleAreaForStackOptimized(dp));
        }

        return maxarea;
    }

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
}
