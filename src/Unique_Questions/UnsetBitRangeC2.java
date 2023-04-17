package Unique_Questions;


//Q= Your are given three number A,B,C.You would unset the C bits of A from right .Your friend would then restore the B
// bits from right to their initial configuration.
// Return the resultant integer.

// 1<=A<=10^9
// 1<=B<=C<=30





public class UnsetBitRangeC2 {
    public int solve(int A, int B, int C) {
        int q=C-B;
        for(int i=0;i<q;i++){
            int h=i+B;
            int f=A&(1<<h);
            if(f!=0){
                A=A^(1<<h);
            }
        }
        return A;
    }
    public static void main(String args []){
        UnsetBitRangeC2 N1=new UnsetBitRangeC2();
        System.out.println( N1.solve(3,1,2));
    }
}


