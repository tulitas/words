package com.company;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;


public class Main {
    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Main project = new Main();
        if (args.length > 0) {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            project.analyse(scanner);

            project.showResults();
        }


//        Scanner INPUT_TEXT = project.readFile();



    }

    /**
     * logic to count the occurences of words matched by REGEX in a scanner that
     * loaded some text
     *
     * @param scanner the scanner holding the text
     */
    private void analyse(Scanner scanner) {

        String pattern = "[a-zA-Z'-]+";
        Pattern r = Pattern.compile(pattern);

        while (scanner.hasNext()) {
            // read next word
            String Stringcandidate = scanner.next();

            // see if pattern matches (boolean find)
            Matcher matcher = r.matcher(Stringcandidate);
            if (matcher.find()) {
                String matchedWord = matcher.group();
                //System.out.println(matchedWord); //check what is matched
                this.addWord(matchedWord);

            }

        }
        scanner.close();// Close your Scanner.
    }

    /**
     * adds a word to the <word,count> Map if the word is new, a new entry is
     * created, otherwise the count of this word is incremented
     */
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

    /**
     * reads a file from disk and returns a scanner to analyse it
     *
     * @return the file from disk as scanner
     */
    public Scanner readFile() {

        Scanner scanner = null;

        /* use that for reading a file from disk
         * try { scanner = new Scanner(new
         * File("moviereview.txt")).useDelimiter(" "); } catch (Exception e) {
         * e.printStackTrace(); }
         */

        scanner = new Scanner("auto bush trumped her tomato in the petunia auto");

        return scanner;
    }

    /**
     * prints the matched words and their occurrences
     * in a readable way
     */
    private void showResults() {

        for (HashMap.Entry<String, Integer> matchedWord : map.entrySet()) {
            int occurrence = matchedWord.getValue();
            System.out.print("\"" + matchedWord.getKey() + "\" appears " + occurrence);
            if (occurrence > 1) {
                System.out.print(" times\n");
            } else {
                System.out.print(" time\n");
            }
        }

    }
}







