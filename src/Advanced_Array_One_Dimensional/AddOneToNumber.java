package Advanced_Array_One_Dimensional;

//Q=Problem Description
//        Given a non-negative number represented as an array of digits, add 1 to the number
//        ( increment the number represented by the digits ).
//
//        The digits are stored such that the most significant digit is at the head of the list.
//
//        NOTE: Certain things are intentionally left unclear in this question which you should practice
//        asking the interviewer. For example: for this problem, the following are some good questions to ask :
//
//        Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
//        A: For the purpose of this question, YES
//        Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
//        A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
//
//
//        Problem Constraints
//        1 <= size of the array <= 1000000



public class AddOneToNumber {
    public int[] plusOne(int[] A) {
        int carry=1;
        int n=A.length;
        for(int i=n-1;i>-1;i--){
            int number=carry+A[i];
            if(number==10){
                A[i]=0;
                carry=1;
            }
            else{
                A[i]=number;
                carry=0;
            }
        }
        if(carry==1){
            int B[]=new int[A.length+1];
            B[0]=1;
            for(int j=0;j<A.length;j++){
                B[j+1]=A[j];
            }
            return B;
        }
        if(A[0]==0){
            int h=0;
            while(A[h]==0){
                h++;
            }
            int C[]=new int[A.length-h];
            for(int t=h;t<A.length;t++){
                C[t-h]=A[t];
            }
            return C;
        }
        return A;
    }
    public static void main(String args []){
        AddOneToNumber R1=new AddOneToNumber();
        int A[] = new int[3];
        A[0]=1;A[1]= 2;A[2]= 3;
        System.out.println(R1.plusOne(A));
    }
}






