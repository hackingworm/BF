import java.util.HashMap;

public class PangramDT {
    public static String findMissingLetters(String str) {
        int[] counters = new int['z' - 'a' + 1];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if ('A' <= c && c <= 'Z') {
                c += 'a' - 'A';
            }

            if ('a' > c || c > 'z') {
                continue;
            }

            counters[c - 'a']++;
        }

        String result = "";
        for (char c = 'a'; c <= 'z'; c++) {
            if(0 == counters[c - 'a']) {
                result += c;
            }
        }

        if (0 == result.length()) {
            return "This is pangram";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetters("The quick brown fox jumps over the lazy dog"));
        System.out.println(findMissingLetters("The quick brown fox jumped over the lazy dog"));
        System.out.println(findMissingLetters("I'm a super fool!"));
    }
}
