package org.kodluyoruz.homework.classes;

public class ThreadSleeper {
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
