package Advance_Unique_Questions;

//Q=Find Out the longest distance between any two adjacent
//        1's in the binary representation of a positve integer A
//
//        Problem Contraints
//              1<=A<2^30



public class SageAndBinaryNumber {
    public int solve(int A) {
        int ans=0;
        int flag=0;
        int count=0;
        int B=A;
        while(A>0){
            if((A&1)==1){
                flag=1;
                count=0;
            }
            if((A&1)!=1 && flag==1){
                count++;
            }
            ans=Math.max(ans,count);
            A=A>>1;
        }
        // Checking A contains only one 1
        int count1=0;
        while(B>0){
            if((B&1)==1){
                count1++;
            }
            B=B>>1;
        }
        if(count1==1){
            return 0;
        }

        return ans+1;
    }


    public static void main(String[] args) {
        SageAndBinaryNumber I = new SageAndBinaryNumber();
        System.out.println(I.solve(11));
    }
}

