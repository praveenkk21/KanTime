package org.practices.DSA.Arrays;

import java.util.*;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // Already visited → duplicate found
                result.add(index + 1);
            } else {
                // Mark as visited by negating
                nums[index] = -nums[index];
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        FindDuplicates fd = new FindDuplicates();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(fd.findDuplicates(nums)); // Output: [2, 3]
    }
}
