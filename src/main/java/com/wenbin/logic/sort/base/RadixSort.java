package com.wenbin.logic.sort.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 */
public class RadixSort extends AbstractValidatableSort {


    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int keysNum = 0;
        while (max > 0) {
            max /= 10;
            keysNum++;
        }

        // 只有10个桶进行初始化
        List<ArrayList<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // 低位开始计算
        for (int i = 0; i < keysNum; i++) {
            for (int j = 0; j < nums.length; j++) {
                //取出该元素对应第i+1位上的数字，比如258，现在要取出十位上的数字，258%100=58,58/10=5
                int key = nums[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                buckets.get(key).add(nums[j]);
            }

            //将桶中的元素复制回数组
            int index = 0;
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> bucket = buckets.get(j);
                while (bucket.size() > 0) {
                    nums[index++] = bucket.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        radixSort.sort(new int[]{3, 4});

        AbstractValidatableSort validatableSort = new RadixSort();
        validatableSort.validate();
    }
}
