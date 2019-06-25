

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    static String regex = ".*12345.*";

    static String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890 ";


    static Scanner scanner = new Scanner(System.in);
    static boolean isSearching = true;
    static long count = 0l;
    static long matchesCount = 0l;
    static long allRandStringsCreated = 0l;
    static long averageCount;
    static int randLength = regex.length() - 4;
    static boolean matches = false;
    static long highestCount;
    static long lowestCount;

    public static void main(String[] args) {


        while (isSearching) {
            rand();
        }
    }


    public static String rand() {
        String rand = "";
        for (int i = 0; i < randLength; i++) {
            rand += alphabet.charAt(ThreadLocalRandom.current().nextInt(0, alphabet.length()));
            if (i % randLength == 0) {
                count += 1;
            }
            if (rand.length() == randLength) {
                printInLine(rand);

            }

        }
        if (rand.matches(regex)) {
            matches = true;
//            allRandStringsCreated is only updated when a new match appears.
//            Then count is added to it. Later count is reset to zero.
            allRandStringsCreated += count;
            matchesCount += 1;
            averageCount = allRandStringsCreated / matchesCount;

            if (count > highestCount) {
                highestCount = count;
            }
            if (matchesCount == 1) {
                lowestCount = count;
            } else if (count < lowestCount) {
                lowestCount = count;
            }
            printInLine(rand);
            count = 0;

        }
        return rand;
    }

    public static void printInLine(String rand2) {
        StringBuilder string = new StringBuilder();
        if (!matches) {
            string.append("\r");

            string.append(rand2);
            string.append(" ").append(count);
            System.out.print(string);
        } else {
            System.out.println("\nmatches " + regex);

            System.out.println("this count: " + count);
            System.out.println("average count: " + averageCount);
            System.out.println("highest count: " + highestCount + "    " + "lowest count: "
                    + lowestCount + "    " + "all Strings created: " + allRandStringsCreated
                    + "     " + "all matches: " + matchesCount);
            System.out.println();
            matches = false;
        }
    }
}
