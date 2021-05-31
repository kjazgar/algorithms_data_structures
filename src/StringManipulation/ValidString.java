package StringManipulation;

import java.io.*;
import java.util.*;

public class ValidString {

    static String isValid(String s) {
        HashMap<Character, Integer> lettersMap = new HashMap<>();
        HashMap<Integer, Integer> amountMap = new HashMap<>();

        for(int i = 0; i < s.length(); ++i){
            char charI = s.charAt(i);
            if(lettersMap.containsKey(charI)){
                lettersMap.replace(charI, lettersMap.get(charI)+1);

            } else {
                lettersMap.put(charI, 1);
            }
        }

        for(int value: lettersMap.values()){
            if(amountMap.containsKey(value)){
                amountMap.replace(value, amountMap.get(value) + 1);

            } else {
                amountMap.put(value, 1);
            }
        }

        if(amountMap.size() == 1){
            StringBuilder yesStr = new StringBuilder("YES");
            return(yesStr.toString());

        }

        if(amountMap.size() > 2){
            StringBuilder noStr = new StringBuilder("NO");
            return(noStr.toString());
        }

        int[] kTab = new int[2];
        int[] vTab = new int[2];

        int ind = 0;
        for(int key: amountMap.keySet()){
            kTab[ind] = key;
            vTab[ind] = amountMap.get(key);
            ind++;
        }

        if(vTab[0] == 1){
            if((kTab[0] == 1)|| (kTab[0] == kTab[1]+1)||(kTab[1] == kTab[0]+1)){
                System.out.println("here2");
                StringBuilder yesStr = new StringBuilder("YES");
                return(yesStr.toString());
            }
        }

        if(vTab[1] == 1){
            if((kTab[1] == 1) || (kTab[0] == kTab[1]+1)||(kTab[1] == kTab[0]+1)){
                System.out.println("here2");
                StringBuilder yesStr = new StringBuilder("YES");
                return(yesStr.toString());
            }
        }

        StringBuilder noStr = new StringBuilder("NO");
        return(noStr.toString());

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
