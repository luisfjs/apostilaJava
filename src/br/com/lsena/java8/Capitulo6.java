package br.com.lsena.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.*;

public class Capitulo6 {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        Function<Usuario, String> byName = Usuario::getNome;

        usuarios.sort(comparing(byName));
        usuarios.sort(comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));
        usuarios.sort(nullsLast(comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome)));

        Supplier<Usuario> criadorDeUsuarios = Usuario::new;
        Usuario novo = criadorDeUsuarios.get();

        Function<String, Usuario> criadorDeUsuariosParam = Usuario::new;
        Usuario usuario1 = criadorDeUsuariosParam.apply("Usuario 1");
        Usuario usuario2 = criadorDeUsuariosParam.apply("Usuario 2");

        BiFunction<String, Integer, Usuario> criadorDeUsuarioBiF = Usuario::new;
        Usuario usuarioBiF1 = criadorDeUsuarioBiF.apply("Usuario 1", 50);
        Usuario usuarioBiF2 = criadorDeUsuarioBiF.apply("Usuario 2", 300);
    }
}
