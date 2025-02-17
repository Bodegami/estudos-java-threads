package br.com.bodegami.patterns.runnable.example1;

public class FirstRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " is running");
        };


        Thread thread = new Thread(runnable);
        thread.setName("My_thread");

        thread.start(); //Vai executar numa nova Thread
        //thread.run(); //Nao vai executar numa nova Thread, mas sim na Thread principal (main thread)
    }

}
