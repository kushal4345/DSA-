package Array;
import java.util.Arrays;

public class RowWithMaximumOnes {

    // Method to find row with maximum ones
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int rowIndex = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, max};
    }

    // Main method to test
    public static void main(String[] args) {
        RowWithMaximumOnes solution = new RowWithMaximumOnes();

        int[][] mat = {
                {0, 1, 1},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[] result = solution.rowAndMaximumOnes(mat);
        System.out.println("Row with max ones: " + result[0]);
        System.out.println("Number of ones: " + result[1]);

        // Or print entire array
        System.out.println("Result array: " + Arrays.toString(result));
    }
}
