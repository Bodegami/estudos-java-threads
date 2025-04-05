package br.com.bodegami.patterns.runnable.correcao;

public class LongWrapper {

    private final Object key = new Object(); //adicionado para resolver o problema de RaceCondition
    private volatile long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    //Sem o syncronized, existe a chance de no momento de recuperar o valor o mesmo nao estar atualizado
    public long getValue() {
        synchronized (key) {
            return l;
        }
    }

    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }

}
