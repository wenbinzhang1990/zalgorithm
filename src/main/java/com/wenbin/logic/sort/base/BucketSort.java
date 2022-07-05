package com.wenbin.logic.sort.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序（稳定）
 */
public class BucketSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int min = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }

    // 计算每个桶数量及初始化
    int bucketNum = (max - min) / nums.length + 1;
    List<List<Integer>> bucket = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
      bucket.add(new ArrayList<>());
    }

    // 将元素放入桶内
    for (int i = 0; i < nums.length; i++) {
      bucket.get((nums[i] - min) / nums.length).add(nums[i]);
    }

    // 对每个桶进行排序
    for (int i = 0; i < bucket.size(); i++) {
      Collections.sort(bucket.get(i));
    }

    // 将排序后的数据写回数组
    int index = 0;
    for (int i = 0; i < bucket.size(); i++) {
      for (int j = 0; j < bucket.get(i).size(); j++) {
        nums[index++] = bucket.get(i).get(j);
      }
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new BucketSort();
    validatableSort.validate();
  }
}
