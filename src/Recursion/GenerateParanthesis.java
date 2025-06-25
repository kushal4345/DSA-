package Recursion;
import java.util.*;
class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        int n =5;
        helper(0, 0, n, new StringBuilder(), res);
        System.out.println(res);
    }

   static void helper(int open, int closed, int n, StringBuilder sb, List<String> res){
        if(sb.length() == 2*n){
            res.add(sb.toString());
        }

        if(open<n){
            sb.append("(");
            helper(open+1, closed, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closed<open){
            sb.append(")");
            helper(open, closed+1, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}