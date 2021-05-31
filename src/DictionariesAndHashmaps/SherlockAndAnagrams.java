package DictionariesAndHashmaps;

import java.io.*;
import java.util.*;


public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> substringMap = new HashMap<>();
        int counter = 0;

        for(int i = 0; i <= s.length() - 1; ++i){
            for(int j = i+1; j <= s.length(); ++j){
                String subs = s.substring(i,j);
                char tempArray[] = subs.toCharArray();
                Arrays.sort(tempArray);
                subs = new String(tempArray);

                if(substringMap.containsKey(subs)){
                    substringMap.replace(subs, substringMap.get(subs)+1);
                    continue;
                }

                substringMap.put(subs, 1);
            }
        }

        for(String key : substringMap.keySet()){
            int n = substringMap.get(key);

            if(n > 1){
                counter += n*(n-1)/2;
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

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
