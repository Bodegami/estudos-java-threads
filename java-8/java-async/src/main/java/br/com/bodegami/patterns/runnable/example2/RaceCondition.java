package br.com.bodegami.patterns.runnable.example2;

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
        //Ao executar o codigo acima, o valor impresso nao sera 1000000, pois pelo fato da operacao de incremento ser Read/Writte
        // e nao atomic, a operacao de incremento pode ser interrompida por outra thread, fazendo com que o valor final seja menor que 1000000
    }

}
