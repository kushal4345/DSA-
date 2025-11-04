package Matrix;

public class SearchInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
       boolean res = searchMatrix(arr,target);
        System.out.println(res);
    }
}
