package com.shanks.practice;

public class Adecco {
    //Create singleton class

    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello Thread 1");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello Thread 2");
        });
        t1.start();
        t2.start();

    }

}

class Singleton {
    private static final Singleton singleton = null;

    public Singleton getInstance() {
        if (singleton == null) {
            return new Singleton();
        }

        return this.singleton;
    }
}
