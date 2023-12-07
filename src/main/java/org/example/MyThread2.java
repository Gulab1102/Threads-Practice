package org.example;

public class MyThread2 extends Thread{
   public void run(){
       for (int i = 0; i < 20; i++) {
           System.out.println("i = " + i);
           try {
               Thread.sleep(10000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
   }

}
