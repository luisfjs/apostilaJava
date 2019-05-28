package br.com.lsena.java8;

import java.util.Comparator;
import java.util.function.Function;

public class Capitulo5 {
    public static void main(String[] args) {
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };


        Comparator<Usuario> comparatorLambda = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
        Comparator<Usuario> comparatorComparing = Comparator.comparing(u -> u.getNome());

        Function<Usuario, String> extraiNome = u -> u.getNome();
        Comparator<Usuario> comparator1 = Comparator.comparing(extraiNome);

        //Usar essa versão para evitar o umboxing, e autoboxing
        Comparator<Usuario> comparatorSemAutoboxing = Comparator.comparingInt(u -> u.getPontos());
    }
}
