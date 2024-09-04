import java.util.Objects;

public class LongestRepeatingSubstring {
    public static int findRepeatingSubstring(String str) {
        int longest = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            int j = i + 1;
            while (true) {
                for (; j < str.length(); j++) {
                    if (ch == str.charAt(j)) {
                        break;
                    }
                }

                if (str.length() == j) {
                    break;
                }

                int len;
                for (len = 1; j + len < str.length(); len++) {
                    if (str.charAt(i + len) != str.charAt(j + len)) {
                        break;
                    }
                }

                if (longest < len) {
                    longest = len;
                }

                j++;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatingSubstring("abcd"));
        System.out.println(findRepeatingSubstring("abbaba"));
        System.out.println(findRepeatingSubstring("aabcaabdaab"));
    }
}
