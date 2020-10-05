package com.company;

import java.io.IOException;
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
        for (String s: args) {
            System.out.println(s);
//        out.println("hello");
//        lines(Path.of(args[0]))
//                .flatMap(l -> of(l.split("[^\\p{IsAlphabetic}]")))
//                .filter(l -> !l.isEmpty())
//                .map(String::toLowerCase)
//                .collect(groupingBy(identity(), counting()))
//                .entrySet().stream()
//                .sorted(comparingLong(Map.Entry<String, Long>::getValue).reversed())
//                .forEach(out::println);

//        try (BufferedReader br = new BufferedReader(new FileReader("book/book.txt"))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//
//            }
//            String everything = sb.toString();
//            List<String> words = new ArrayList<>();
//
//            words.add(everything);


//            int k[] = new int[]{-1, 0};
//            for (int i = 0; i < words.size(); i++) {
//                if (!words.get(k[1]).equals(words.get(i)) || k[0] < 0) {
//                    int c = 1;
//                    for (int p = i + 1; p < words.size(); p++) {
//                        if (words.get(i).equals(words.get(p))) {
//                            c++;
//                        }
//                    }
//                    if (k[0] < c) {
//                        k[0] = c;
//                        k[1] = i;
//                    }
//                }
//            }
//            System.out.println("Самое повторяющееся слово: " + words.get(k[1]) + " (встречается " + k[0] + " раз)");

        }
    }

