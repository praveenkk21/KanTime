package org.practices.DSA.Arrays;

public class ReverseAnArray {

    int[] rev(int arr[], int n) {
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - i - 1];
        }
        return rev;
    }

    public static void main(String args[]) {
        ReverseAnArray obj = new ReverseAnArray();
        int arr[] = {1, 3, 5, 7, 9};
        int n = arr.length;
        int[] reversed = obj.rev(arr, n);

        System.out.print("Reversed array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(reversed[i] + " ");
        }
    }
}
