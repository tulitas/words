package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("book/book.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            List<String> words = new ArrayList<>();

            words.add(everything);

            int k[] = new int[]{-1, 0};
            for (int i = 0; i < words.size(); i++) {
                if (!words.get(k[1]).equals(words.get(i)) || k[0] < 0) {
                    int c = 1;
                    for (int p = i + 1; p < words.size(); p++) {
                        if (words.get(i).equals(words.get(p))) {
                            c++;
                        }
                    }
                    if (k[0] < c) {
                        k[0] = c;
                        k[1] = i;
                    }
                }
            }
            System.out.println("Самое повторяющееся слово: " + words.get(k[1]) + " (встречается " + k[0] + " раз)");

    }
}}
