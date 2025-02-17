package br.com.bodegami.example2;

public class LongWrapper {

    private final Object key = new Object(); //adicionado para resolver o problema de RaceCondition
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }

}
