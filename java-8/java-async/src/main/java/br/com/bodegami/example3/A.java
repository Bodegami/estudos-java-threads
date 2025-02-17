package br.com.bodegami.example3;

public class A {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] i am in a()");
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            System.out.println("[" + Thread.currentThread().getName() + "] i am in b()");
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] i am in c()");
        }
    }

}
