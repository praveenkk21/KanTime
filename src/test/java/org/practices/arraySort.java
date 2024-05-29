package org.practices;

import org.testng.annotations.Test;


public class arraySort {
    static int[] arr = new int[]{5, 2, 8, 7, 1};
    static int temp = 0;

    @Test
    public static void ascArray() {
        asc(arr);
        findMax(arr);
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
    }

    public static int[] asc(int[] arra) {
        for (int i = 0; i < arra.length; i++) {
            for (int j = i + 1; j < arra.length; j++) {
                if (arra[i] < arra[j]) {
                    temp = arra[j];
                    arra[j] = arra[i];
                    arra[i] = temp;
                }
            }
        }
        return arr;
    }

    public static void findMax(int[] arra){
        int max=arra[0];
        for(int i=1;i<arra.length;i++){
            if(max<arra[i]){
                max=arra[i];
            }
        }
        System.out.println(max);
    }
}