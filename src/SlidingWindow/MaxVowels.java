package SlidingWindow;
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int count = 0, max = 0, j = 0;

        // first window
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                count++;
            }
        }

        // maintaining the window
        for (int i = k; i < s.length(); i++) {
            max = Math.max(max, count);

            // add right character
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                count++;
            }

            // remove left character
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i'
                    || s.charAt(j) == 'o' || s.charAt(j) == 'u') {
                count--;
            }

            j++;
        }

        // final window check
        max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        MaxVowels solution = new MaxVowels();

        String s = "abciiidef";
        int k = 3;

        int result = solution.maxVowels(s, k);
        System.out.println("Maximum number of vowels in substring of length " + k + " is: " + result);
    }
}
