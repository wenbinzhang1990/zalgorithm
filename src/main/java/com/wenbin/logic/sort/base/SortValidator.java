package com.wenbin.logic.sort.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Sort 验证器
 */
public class SortValidator {

    Set<int[]> CASE_SET = new HashSet<>();

    int[] TRUE_SORTED_ARRAY = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 10};

    public SortValidator() {
        CASE_SET.add(null);
        CASE_SET.add(new int[]{10, 8, 7, 6, 5,5, 4, 3, 2, 1});
        CASE_SET.add(new int[]{2, 3, 4, 5, 5, 6, 7, 8, 10, 1});
        CASE_SET.add(new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 10});
        CASE_SET.add(new int[]{8, 7, 6, 5, 5, 4, 3, 2, 10, 1});
        CASE_SET.add(new int[]{4, 5, 5, 6, 7, 8, 1, 10, 2, 3});
        CASE_SET.add(new int[]{1, 2, 3, 4, 5, 8, 7, 6, 5, 10});
        CASE_SET.add(new int[]{5, 2, 1, 3, 4, 6, 8, 10, 7, 5});
    }

    /**
     * Validate the sorted array.
     *
     * @throws IllegalStateException
     */
    public void validate(int[] sortedNums) {
        if (sortedNums == null) {
            return;
        }

        if (!Arrays.equals(sortedNums, TRUE_SORTED_ARRAY)) {
            throw new IllegalStateException();
        }
    }
}
