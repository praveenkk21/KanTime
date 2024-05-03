package org.example;

import org.testng.annotations.Test;

public class recursive {

    @Test
    public void getResult() {
        int result = sum(10);
        System.out.println(result);
    }

public static int sum(int k) {
    if (k > 0) {
        return k + sum(k - 1);
    } else {
        return 0;
    }
}
}
