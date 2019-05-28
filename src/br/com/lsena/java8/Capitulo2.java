package br.com.lsena.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//Formas de criar um consumer, para usar no foreach
public class Capitulo2 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Usuario 1", 150);
        Usuario user2 = new Usuario("Usuario 2", 120);
        Usuario user3 = new Usuario("Usuario 3", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }

        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        Consumer<Usuario> mostrador1 = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };

        usuarios.forEach(mostrador1);
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        usuarios.forEach(u -> System.out.println(u.getNome()));
    }
}
