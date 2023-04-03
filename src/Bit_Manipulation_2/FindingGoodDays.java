package Bit_Manipulation_2;



//Q=Problem Description
//        Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
//
//        He starts on day 1 with one stash of food unit, every next day, the stash doubles.
//
//        If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.
//
//        Boomer receives a net worth of A units of food. What is the number of days she received the stash?



public class FindingGoodDays {
    public int solve(int A) {
        int ans=0;
        while(A>0){
            if(A%2!=0){
                ans++;
            }
            A=A>>1;
        }
        return ans;
    }
    public static void main(String args []){
        FindingGoodDays N1=new FindingGoodDays();
        System.out.println( N1.solve(7));
    }
}
