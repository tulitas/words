package com.company;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static java.lang.System.out;
import static java.lang.System.setOut;
import static java.nio.file.Files.lines;
import static java.util.Comparator.comparingLong;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Stream.of;

public class Main {
    private static String value;
    //    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {



            lines(Path.of(value))
                    .flatMap(l -> of(l.split("[^\\p{IsAlphabetic}]")))
                    .filter(l -> !l.isEmpty())
                    .map(String::toLowerCase)
                    .collect(groupingBy(identity(), counting()))
                    .entrySet().stream()
                    .sorted(comparingLong(Map.Entry<String, Long>::getValue).reversed())
                    .forEach(out::print);
//        }
//        Main projectWords = new Main();
//
//        if (args.length > 0) {
//            File file = new File(args[0]);
//            Scanner scanner = new Scanner(file);
//            projectWords.analyse(scanner);
//            projectWords.showResults();
//        }
//    }
//
//    private void analyse(Scanner scanner) {
//
//        String pattern = "[a-zA-Z'-]+";
//        Pattern r = Pattern.compile(pattern);
//
//        while (scanner.hasNext()) {
//            // read next word
//            String StringCandidateNewWord = scanner.next();
//
//            // see if pattern matches (boolean find)
//            Matcher matcher = r.matcher(StringCandidateNewWord);
//            if (matcher.find()) {
//                String matchedWord = matcher.group();
//                this.addWord(matchedWord);
//            }
//        }
//        scanner.close();
//    }
//
//    private void addWord(String matchedWord) {
//        if (map.containsKey(matchedWord)) {
//            // increment occurrence
//            int occurrence = map.get(matchedWord);
//            occurrence++;
//            map.put(matchedWord, occurrence);
//
//        } else {
//            // add word and set occurrence to 1
//            map.put(matchedWord, 1);
//        }
//    }
//
//    private void showResults() {
//
//        ValueComparator bvc = new ValueComparator(map);
//        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
//        sorted_map.putAll(map);
//        System.out.println(sorted_map);
//    }
    }

}





