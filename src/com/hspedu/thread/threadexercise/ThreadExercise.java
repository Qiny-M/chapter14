package com.hspedu.thread.threadexercise;

import java.util.Scanner;

public class ThreadExercise {
    public static void main(String[] args) {
        /*在main方法中启用两个线程
         * 一个循环输出1到100当中到随机数
         * 直到另一个线程接受到键盘输入的Q或q
         * */
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();

    }
}

class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    private A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入大写或小写的Q以终止线程");
            char s = scanner.next().toUpperCase().charAt(0);
            if (s == 'Q') {
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}