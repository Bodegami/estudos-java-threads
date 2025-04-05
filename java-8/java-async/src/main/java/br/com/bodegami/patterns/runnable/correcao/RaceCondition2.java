package br.com.bodegami.patterns.runnable.correcao;

public class RaceCondition2 {

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.incrementValue();
            }
        };

        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Value = " + longWrapper.getValue());

        //Apos as alteracoes na classe LongWrapper (inclusao da key e uso do syncronized dentro do metodo incrementValue())
        // , o valor impresso sera 1000000
    }

}
