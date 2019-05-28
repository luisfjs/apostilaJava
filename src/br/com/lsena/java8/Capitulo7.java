package br.com.lsena.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo7 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Usuario 1", 150);
        Usuario user2 = new Usuario("Usuario 2", 90);
        Usuario user3 = new Usuario("Usuario 3", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Stream<Usuario> stream = usuarios.stream().filter(u -> u.getPontos() > 100);
        stream.forEach(System.out::println);

        usuarios.stream().filter(u -> u.getPontos() > 100)
                         .forEach(System.out::println);

        usuarios.stream().filter(u -> u.getPontos() > 100)
                         .forEach(Usuario::tornaModerador);

        Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
        BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;

        List<Usuario> maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                                                    .collect(supplier, accumulator, combiner);

        maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                .collect(Collectors.toList());

        Set<Usuario> setMaisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                                            .collect(Collectors.toSet());

        setMaisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                .collect(Collectors.toCollection(HashSet::new));

        Usuario[] arrayMaisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100)
                .toArray(Usuario[]::new);

        List<Integer> pontos = new ArrayList<>();
        //usuarios.forEach(u -> pontos.add(u.getPontos()));

        pontos = usuarios.stream().map(u -> u.getPontos()).collect(Collectors.toList());
        //Usando Method Reference
        pontos = usuarios.stream().map(Usuario::getPontos).collect(Collectors.toList());

        //Evitano boxing de primitivos
        IntStream intStream = usuarios.stream().mapToInt(Usuario::getPontos);

        double pontuacaoMedia = usuarios.stream().mapToInt(Usuario::getPontos).average().getAsDouble();

        OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();

        pontuacaoMedia = media.orElse(0.0);

        //se for vazio retorna 0.0
        pontuacaoMedia = usuarios.stream().mapToInt(Usuario::getPontos).average().orElse(0.0);

        //se for vazio lança uma exceção
        pontuacaoMedia = usuarios.stream().mapToInt(Usuario::getPontos).average().orElseThrow(IllegalStateException::new);

        //Consome resultado
        usuarios.stream().mapToInt(Usuario::getPontos).average().ifPresent(valor -> System.out.println(valor));

        Optional<Usuario> max = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos));

        Optional<String> maxNome = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos)).map(Usuario::getNome);
    }
}
