package StringManipulation;

import java.io.*;
import java.util.*;


public class MakingAnagrams {

    static int makeAnagram(String a, String b) {
        int[] aTab = new int[26];
        int[] bTab = new int[26];
        int counter = 0;

        for(int ind = 0 ; ind < 26; ind++){
            aTab[ind] = 0;
            bTab[ind] = 0;
        }

        for(int i = 0; i< a.length(); ++i){
            char charI = a.charAt(i);
            int ascii = (int) charI;
            aTab[ascii - 97] += 1;
        }

        for(int i = 0; i< b.length(); ++i){
            char charI = b.charAt(i);
            int ascii = (int) charI;
            bTab[ascii - 97] += 1;
        }

        for(int i = 0; i<26; ++i){
            if(aTab[i] != bTab[i]){
                counter += Math.abs(aTab[i]-bTab[i]);
            }
        }

        return counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}