package Recursion;

public class CountZeros {
    static int countZero(int num,int count){

        if(num<=0){
            return count;  // return count when base condition hit
        }
        if(num%10==0){    // if zero exist in num then count will increment by one
            count++;
        }

       return countZero(num/10,count);
    }
    public static void main(String args[]){
        int num = 3804009;
        int count =0;
       System.out.println(countZero(num,count));
    }
}
