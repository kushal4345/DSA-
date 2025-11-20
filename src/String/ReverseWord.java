package String;
import java.util.*;
public class ReverseWord {
    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", arr);
    }
    public static void main(String[] args) {


        String input = "  the sky   is    blue  ";
        String output = reverseWords(input);

        System.out.println("Original: \"" + input + "\"");
        System.out.println("Reversed: \"" + output + "\"");
    }
}




