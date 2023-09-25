package Advance_DP_Two_Dimension;

//Q=Problem Description
//        Given a number A, return number of ways you can draw A chords in a circle with 2 x A
//        points such that no 2 chords intersect.
//
//        Two ways are different if there exists a chord which is present in one way and not in other.
//        Return the answer modulo 109 + 7.
//
//
//
//        Problem Constraints

//        1 <= A <= 10^3
//
//
//
//        Input Format

//        The first and the only argument contains the integer A.
//
//
//
//        Output Format

//        Return an integer answering the query as described in the problem statement.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 1

//        Input 2:
//
//        A = 2
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are:
//        {(1-2)} only. So, we return 1.
//        Explanation 2:
//
//        If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords
//        are:{(1-2), (3-4)} and {(1-4), (2-3)}.
//        So, we return 2.


public class IntersectingChordsInACircle {
    int dp[];
    int mod=(int)(Math.pow(10,9)+7);

    int catlon_number(int A){
        if(dp[A]!=0){
            return dp[A];
        }
        long ans=0;
        for(int i=0;i<A;i++){
            ans=(ans+((1L*catlon_number(i))*catlon_number(A-i-1))%mod)%mod;
        }
        dp[A]=(int)(ans);
        return dp[A];
    }
    public int chordCnt(int A) {
        dp=new int[A+1];
        dp[0]=1;
        dp[1]=1;


        return catlon_number(A);
    }
    public static void main(String[] args) {
        IntersectingChordsInACircle I = new IntersectingChordsInACircle();
        System.out.println( I.chordCnt(100));
    }
}


