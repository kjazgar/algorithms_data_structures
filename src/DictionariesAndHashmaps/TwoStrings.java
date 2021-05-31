package DictionariesAndHashmaps;

import java.io.*;
import java.util.*;


public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        HashMap<Character, Integer> letterS1 = new HashMap<Character, Integer>();

        for(int i = 0; i< s1.length(); ++i){
            char charI = s1.charAt(i);
            if(letterS1.containsKey(charI)){
                letterS1.put(charI, letterS1.get(charI)+1);
                continue;
            }

            letterS1.put(charI, 1);
        }

        for(int i = 0; i< s2.length(); ++i){
            char charI = s2.charAt(i);
            if(letterS1.containsKey(charI)){
                return "YES";
            }
        }

        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
