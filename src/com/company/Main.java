package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Main projectWords = new Main();

        if (args.length > 0) {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            projectWords.analyse(scanner);
            projectWords.showResults();
        }
    }

    private void analyse(Scanner scanner) {

        String pattern = "[a-zA-Z'-]+";
        Pattern r = Pattern.compile(pattern);

        while (scanner.hasNext()) {
            // read next word
            String StringCandidateNewWord = scanner.next();

            // see if pattern matches (boolean find)
            Matcher matcher = r.matcher(StringCandidateNewWord);
            if (matcher.find()) {
                String matchedWord = matcher.group();
                this.addWord(matchedWord);
            }
        }
        scanner.close();
    }

    private void addWord(String matchedWord) {
        if (map.containsKey(matchedWord)) {
            // increment occurrence
            int occurrence = map.get(matchedWord);
            occurrence++;
            map.put(matchedWord, occurrence);

        } else {
            // add word and set occurrence to 1
            map.put(matchedWord, 1);
        }
    }

    private void showResults() {

        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(map);
        System.out.println(sorted_map);
    }
}







