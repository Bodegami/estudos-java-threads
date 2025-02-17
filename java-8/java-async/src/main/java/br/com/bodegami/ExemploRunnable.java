package br.com.bodegami;

public class ExemploRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " is running");
        };


        Thread thread = new Thread(runnable);
        thread.setName("Thead-Async");

        thread.start();

    }

}
