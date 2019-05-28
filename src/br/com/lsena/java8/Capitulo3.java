package br.com.lsena.java8;

public class Capitulo3 {
    public static void main(String[] args) {
        Runnable o = () -> System.out.println("O que sou eu? Que lambda?");
        System.out.println(o);
        System.out.println(o.getClass());

        int numero = 5;
        new Thread(() -> System.out.println(numero)).start();
    }
}
