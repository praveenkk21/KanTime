package org.practices.DSA.Arrays;

public class CheckOccuranceOFElement {
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 6, 2};
        int target = 2;
        System.out.println("The number " + target + " occurs " + countOccurrences(arr, target) + " times.");
    }
}
