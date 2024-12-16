package com.her.synchronized_this;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class synchronizedThis {

    // Synchronized (this)
    public static void main(String[] args) {
        synchronizedThis sThis = new synchronizedThis();

        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작 " + LocalDateTime.now());
            sThis.syncBlockMethod1("스레드1");
            System.out.println("스레드1 종료 " + LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작 " + LocalDateTime.now());
            sThis.syncBlockMethod2("스레드2");
            System.out.println("스레드2 종료 " + LocalDateTime.now());
        });

        thread1.start();
        thread2.start();

    }

    private void syncBlockMethod1 (String msg) {
        synchronized (this){
            System.out.println(msg + "의 syncBlockMethod1 실행중  " + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void syncBlockMethod2 (String msg) {
        synchronized (this){
            System.out.println(msg + "의 syncBlockMethod2 실행중  " + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
