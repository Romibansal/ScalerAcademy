package Advanced_Array_One_Dimensional;

//Q=Problem Description
//        You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
//
//        Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
//
//        If you don't want to perform the operation, return an empty array.
//        Else, return an array consisting of two elements denoting L and R.
//        If there are multiple solutions, return the lexicographically smallest pair of L and R.
//
//        NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
//
//
//
//        Problem Constraints
//        1 <= size of string <= 100000

public class Flip {
    public int[] flip(String A) {
        int count=0;
        int l=-1;
        int r=-1;
        int temp_l=-1;
        int temp_r=-1;
        int temp_count=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='0'){
                temp_count++;
            }
            else{
                temp_count--;
            }
            if(temp_count==1 && temp_l<0){
                temp_l=i;
                temp_r=i;
            }
            temp_r=i;
            if(temp_count>count){
                count=temp_count;
                l=temp_l;
                r=temp_r;
            }
            if(temp_count<0){
                temp_count=0;
                temp_l=-1;
                temp_r=-1;
            }
        }
        if(l==-1){
            int []ans=new int[0];
            return ans;
        }
        else{
            int[] ans=new int[2];
            ans[0]=l+1;
            ans[1]=r+1;
            return ans;
        }
    }
    public static void main(String args []){
        Flip R1=new Flip();
        String A="0000111";
        System.out.println(R1.flip(A));
    }
}




