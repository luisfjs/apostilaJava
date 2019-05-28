package br.com.lsena.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Capitulo9 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Usuario 1", 150, true);
        Usuario user2 = new Usuario("Usuario 2", 120, true);
        Usuario user3 = new Usuario("Usuario 3", 90);
        Usuario user4 = new Usuario("Usuario 4", 120);
        Usuario user5 = new Usuario("Usuario 5", 100);
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Path, Long> lines  = null;
        try {
            lines = Files.list(Paths.get("/home/lsena/Projetos/Java/apostilaJava/src/br/com/lsena/java8")).collect(Collectors.toMap(Function.identity(), p -> Capitulo8.lines(p).count()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);

        Map<String, Usuario> nameToUser = usuarios
                .stream()
                .collect(Collectors.toMap(
                        Usuario::getNome,
                        Function.identity()));

        Map<Integer, List<Usuario>> pontuacao = new HashMap<>();
        for(Usuario u: usuarios) {
            pontuacao.computeIfAbsent(u.getPontos(), user -> new ArrayList<>()).add(u);
        }
        System.out.println(pontuacao);

        pontuacao = usuarios.stream().collect(Collectors.groupingBy(Usuario::getPontos));
        System.out.println(pontuacao);

        Map<Boolean, List<Usuario>> moderadores = usuarios
                .stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));

        Map<Boolean, List<String>> nomesPortipo = usuarios
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.mapping(Usuario::getNome,
                                        Collectors.toList())));


        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        long sum = LongStream.range(0, 20000000).parallel().filter(x -> x % 2 == 0).sum();
        System.out.println(Duration.between(now, LocalDateTime.now()).toMillis());
        System.out.println(LocalDateTime.now());
    }
}
