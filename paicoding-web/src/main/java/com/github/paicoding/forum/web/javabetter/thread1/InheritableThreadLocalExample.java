package com.github.paicoding.forum.web.javabetter.thread1;

class InheritableThreadLocalExample {
    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> childLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("父线程的值");

        new Thread(() -> {
            childLocal.set("zj1");
            System.out.println("子线程获取的值：" + inheritableThreadLocal.get()); // 继承了父线程的值
            System.out.println("子线程的值：" + childLocal.get()); // 继承了父线程的值

        }).start();

        new Thread(() -> {
            childLocal.set("zj2");
            System.out.println("子线程获取的值：" + inheritableThreadLocal.get()); // 继承了父线程的值
        }).start();
    }
}