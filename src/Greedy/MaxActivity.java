package Greedy;

import java.util.Arrays;

public class MaxActivity {
    public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;


        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }


        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 3: Greedy selection
        int count = 1;  // pick first activity
        int lastFinish = activities[0][1];

        for (int i = 1; i < n; i++) {
            int currStart = activities[i][0];
            int currFinish = activities[i][1];
            if (currStart >= lastFinish) {
                count++;
                lastFinish = currFinish;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        System.out.println(activitySelection(start, finish));
    }
}
