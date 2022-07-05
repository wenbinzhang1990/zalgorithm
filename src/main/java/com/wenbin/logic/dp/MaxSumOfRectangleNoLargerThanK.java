package com.wenbin.logic.dp;

/**
 * 矩形区域不超过 K 的最大数值和 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumOfRectangleNoLargerThanK {

  public int maxSumSubMatrix(int[][] matrix, int k) {
    //固定左右边界，求出该左右边界内每行的和用rowsum[]存储，只考虑哪两个行之间的矩形和最大，就变成了求rowsum中小于K的最大子序和的问题
    //1、划定左右边界，求每行和；2、找不超过K的两行的组合（即对应矩阵）的最大值
    //为什么用列划分，因为行数远超于列数
    int row = matrix.length;//行数
    //非空矩阵不用判断特殊情况
    int col = matrix[0].length;//列树
    int res = Integer.MIN_VALUE;//初始化结果为最小值
    for (int l = 0; l < col; l++) {//l为左边界
      int[] rowSum = new int[row];//每一行的和的数组
      for (int r = l; r < col; r++) {//r为有边界
        for (int i = 0; i < row; i++) {
          //求当前左右边界[l,r]时每行的和的前缀和，以便求不同行之间的矩形和
          rowSum[i] += matrix[i][r];
        }
        //求[l,r]边界下矩阵不超过k的最大矩形和
        res = Math.max(res, lrMax(rowSum, k));
        if (res == k) {
          return k;//尽量减少运算
        }
      }
    }
    return res;
  }

  //求[l,r]边界下矩阵不超过k的最大矩形和
  public int lrMax(int[] rowSum, int k) {
    //动态规划参考最大子序和那题
    int max = Integer.MIN_VALUE;
    int dp = 0;//维护当前元素为结尾的之前所有连续子数组的最大的和
    for (int num : rowSum) {
      dp = dp > 0 ? dp + num : num;
      max = Math.max(dp, max);
      if (max == k) {
        return k;
      }
    }
    //因为有不大于k的限制，所以可能会因为dp<0断开而漏掉一些值
    if (max <= k) {
      return max;//如果k在已求得最大值上，就不存在上述问题
    }
    //如果k比无限制时求得的max小，就要重新把所有情况计算下来了 这里采用暴力法
    max = Integer.MIN_VALUE;
    for (int i = 0; i < rowSum.length; i++) {
      int sum = 0;
      for (int j = i; j < rowSum.length; j++) {
        //i到j行之间的和就是依次叠加
        sum += rowSum[j];
        if (sum <= k && sum > max) {
          max = sum;
        }
        if (max == k) {
          return k;
        }
      }
    }
    return max;
  }
}
