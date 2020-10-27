package com.company;

import java.io.*;
import java.nio.file.Path;
import java.util.Map;

import static java.lang.System.out;
import static java.nio.file.Files.lines;
import static java.util.Comparator.comparingLong;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Stream.of;

public class Main {

    public static void main(String[] args) throws IOException {


            lines(Path.of(args[0]))
                    .flatMap(l -> of(l.split("[^\\p{IsAlphabetic}]")))
                    .filter(l -> !l.isEmpty())
                    .map(String::toLowerCase)
                    .collect(groupingBy(identity(), counting()))
                    .entrySet().stream()
                    .sorted(comparingLong(Map.Entry<String, Long>::getValue).reversed())
                    .forEach(out::print);
    }
}