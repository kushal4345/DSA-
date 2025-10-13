package Array;
import java.util.*;
public class IntersectionOfTwoArray {
    public static void main(String[] args) {
       int nums1 [] = {1,2,2,1};
        int nums2 [] = {2,2};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> u = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (set.contains(nums1[i])) {
                u.add(nums1[i]);
            }
        }


        int[] result = new int[u.size()];
        int index = 0;
        for (int num : u) {
            result[index++] = num;
        }
    }
}
