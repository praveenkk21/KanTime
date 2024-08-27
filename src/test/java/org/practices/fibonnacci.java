package org.practices;

import java.util.Scanner;

public class fibonnacci {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter n: ");
        int n=sc.nextInt();
        int n1 = n;
        fib (n1);
        }
    public static void fib(int n){
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = a + sum;
            a = b;
            b = sum;
            System.out.println(sum);
        }
    }
}
