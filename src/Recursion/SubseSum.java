package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubseSum {
    public static void set(int nums[], int index, List<Integer> current) {
        if (index == nums.length) {
            int sum = 0;
            for (int i = 0; i < current.size(); i++) {
                sum = sum + current.get(i);
            }
            System.out.println(sum);
            return;
        }

        current.add(nums[index]);
        set(nums, index + 1, current);
        current.remove(current.size() - 1);
        set(nums, index + 1, current);
    }

    public static void main(String args[]) {
        int nums[] = {5, 2, 1};
        int index = 0;
        set(nums, index, new ArrayList<>());
    }
}
