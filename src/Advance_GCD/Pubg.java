package Advance_GCD;

//Q=Problem Description
//        There are N players, each with strength A[i]. when player i attack player j,
//        player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.
//
//        Can you tell the minimum health last surviving person can have?
//
//        Problem Constraints
//        1 <= N <= 100000
//
//        1 <= A[i] <= 1000000

public class Pubg {
    int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return (gcd((b%a),a));
    }
    public int solve(int[] A) {
        int ans=A[0];
        for(int i=1;i<A.length;i++){
            ans=gcd(ans,A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Pubg I = new Pubg();
        int[] A=new int[3];
        A[0]=2;A[1]= 3;A[2]= 4;
        System.out.println(I.solve(A ));
    }
}


