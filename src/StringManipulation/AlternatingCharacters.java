package StringManipulation;

import java.io.*;
import java.util.*;


public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int[] sTab = new int[s.length()];
        int counter = 0;

        for(int i = 0; i< s.length(); ++i){
            char charI = s.charAt(i);
            if(charI == 'A'){
                sTab[i] = 1;
            } else {
                sTab[i] = 0;
            }
        }

        for(int i = 0; i < s.length()-1; ++i){
            if(sTab[i]+sTab[i+1] != 1){
                counter += 1;
            }
        }

        return counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
