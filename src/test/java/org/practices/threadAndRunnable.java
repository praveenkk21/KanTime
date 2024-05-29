package org.practices;
import org.testng.annotations.*;

//There are two ways to create a thread:
//By extending Thread class
//By implementing Runnable interface.

import org.testng.annotations.Test;

public class threadAndRunnable extends Thread {
    private volatile boolean shouldStop = false;
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is running with " + i);
            if(i==3 && Thread.currentThread().getName().equals("kumar"))
            {
                shouldStop = true;
                break;
            }
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        threadAndRunnable task = new threadAndRunnable(); // Single instance of Runnable

        // Create and start two threads
        Thread t1 = new Thread(task, "praveen");
        Thread t2 = new Thread(task, "kumar");
        Thread t3 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
    }
}

//class ThreadAndRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(Thread.currentThread().getName() + " is running with " + i);
//            try {
//                Thread.sleep(1000); // Simulate some work
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Test
//    public static void testInt(){
//        // Create two Runnable instances (optional)
//        Runnable task1 = new ThreadAndRunnable();
//        Runnable task2 = new ThreadAndRunnable(); // Can be reused or create a new instance
//
//        // Create and start two threads
//        Thread t1 = new Thread(task1, "Thread-1");
//        Thread t2 = new Thread(task2, "Thread-2");
//        t1.start();
//        t2.start();
//    }
//}


