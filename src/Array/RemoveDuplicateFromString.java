package Array;
import java.sql.SQLOutput;
import java.util.*;
public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        String result = "";
        String s = "geeksforgeeks";
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){  // if contains skip else add in final string
            if(!set.contains(s.charAt(i))){
                result +=s.charAt(i);
            }
            set.add(s.charAt(i));
        }
        System.out.println(result);  //  final string
    }
}
