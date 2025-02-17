package br.com.bodegami.example2;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.incrementValue();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        thread.join(); //Espera a thread terminar para executar o restante do codigo

        System.out.println("Value = " + longWrapper.getValue());
    }

}
