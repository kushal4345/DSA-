package DP;
import java.util.*;

public class LongestCommon_Substring {
    public static void main(String[] args) {
        String a = "abcdef";
        String b = "defagh";

        int max = 0;

        for (int i = 0; i < a.length(); i++) {
                String s = a.substring(i, a.length());

                if (b.contains(s)) {
                    max = Math.max(max, s.length());
                }

        }

        System.out.println(max);
    }
}