package br.com.bodegami.example3;

public class RunningA {

    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        Runnable r1 = () -> a.a();
        Runnable r2 = () -> a.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();

        //Aqui temos um exemplo de Deadlock, pois a thread 1 está com o key1 e tenta pegar o key2,
        // enquanto a thread 2 está com o key2 e tenta pegar o key1
        //Dessa forma, o codigo fica no loop eterno e não consegue sair.
        //Para resolver este problema, devemos reiniciar a JVM

    }

}
