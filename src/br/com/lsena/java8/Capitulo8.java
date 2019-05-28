package br.com.lsena.java8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo8 {

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Usuario 1", 150);
        Usuario user2 = new Usuario("Usuario 2", 90);
        Usuario user3 = new Usuario("Usuario 3", 190);
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
        List<Usuario> usuarioVazio = new ArrayList<>();
        usuarios.sort(Comparator.comparing(Usuario::getNome));
        usuarios.stream().filter(u -> u.getPontos() > 100).sorted(Comparator.comparing(Usuario::getNome));
        List<Usuario> filtradosOrdenados = usuarios.stream().filter(u -> u.getPontos() > 100).sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList());
        usuarios.stream().filter(u -> u.getPontos() > 100);
        usuarios.stream().filter(u -> u.getPontos() > 100).peek(System.out::println).findAny();
        usuarios.stream().filter(u -> u.getPontos() > 150).peek(System.out::println).findAny();
        int valorInicial = 0;
        IntBinaryOperator operacao = (a, b) -> a + b;
        int total = usuarios.stream().reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);
        boolean hasModerador = usuarios.stream().anyMatch(Usuario::isModerador);
        Random random = new Random(0);
        Supplier<Integer> supplier = () -> random.nextInt();
        IntStream stream = IntStream.generate(() -> random.nextInt());
        class Fibonacci implements IntSupplier {
            private int anterior = 0;
            private int proximo = 1;

            public int getAsInt() {
                proximo = proximo + anterior;
                anterior = proximo - anterior;
                return anterior;
            }
        }
        IntStream.generate(new Fibonacci()).limit(10).forEach(System.out::println);
        IntStream.generate(new Fibonacci()).limit(15).forEach(System.out::println);
        IntStream.generate(new Fibonacci()).limit(5).forEach(System.out::println);
        IntStream.generate(new Fibonacci()).filter(f -> f > 100).findFirst().getAsInt();
        IntStream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);

        try {
            Files.list(Paths.get("./")).forEach(System.out::println);
            Files.list(Paths.get("./java8")).forEach(System.out::println);
            Files.list(Paths.get("./java8")).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}