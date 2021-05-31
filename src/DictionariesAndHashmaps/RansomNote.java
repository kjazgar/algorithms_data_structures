package DictionariesAndHashmaps;

import java.util.*;


public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineWords = new HashMap<String, Integer>();
        HashMap<String, Integer> noteWords = new HashMap<String, Integer>();

        for(String i: magazine){
            if(magazineWords.containsKey(i)){
                magazineWords.replace(i, magazineWords.get(i) + 1);
            } else{
                magazineWords.put(i, 1);
            }
        }

        for(String i: note){
            if(!magazineWords.containsKey(i)){
                System.out.println("No");
                return;
            }

            if(magazineWords.get(i) == 1){
                magazineWords.remove(i);
                continue;
            }

            magazineWords.replace(i, magazineWords.get(i) - 1);

        }

        System.out.println("Yes");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
