package Hashing;
import java.util.*;

public class Basic {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = {1, 1, 1, 4, 5, 2, 2, 4};

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);//.getdefault check whether the value is exist or not if yes then it increment by 1 else 0 in default
        }

        System.out.println(map);
    }
}
