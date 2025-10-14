package Array;

import java.util.HashMap;

public class CountCharacter {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        String a = "takeyouforward";
        for(int i =0;i<a.length();i++){   // counting freq
            char c = a.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        for (char ch : map.keySet()) {  // printing freq along with character
            String charint = String.valueOf(map.get(ch));
            String s = ch + charint;
            System.out.println(s);
        }
    }
}
