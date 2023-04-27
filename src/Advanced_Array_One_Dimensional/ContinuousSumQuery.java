package Advanced_Array_One_Dimensional;

//
//Q=Problem Description
//        There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
//        When the devotees come to the temple, they donate some amount of coins to these beggars.
//        Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars
//        sitting next to each other.
//
//        Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A,
//        find out the final amount of money in each beggar's pot at the end of the day,
//        provided they don't fill their pots by any other means.
//        For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
//
//
//        Problem Constraints
//        1 <= A <= 2 * 10^5
//        1 <= L <= R <= A
//        1 <= P <= 103
//        0 <= len(B) <= 10^5

public class ContinuousSumQuery {
    public int[] solve(int A, int[][] B) {
        int [] ans=new int[A];
        for(int i=0;i<B.length;i++){
            int l=B[i][0];
            int r=B[i][1];
            int value=B[i][2];
            ans[l-1]=ans[l-1]+value;
            if(r<A){
                ans[r]=ans[r]-value;
            }
        }
        for(int j=1;j<A;j++){
            ans[j]=ans[j]+ans[j-1];
        }
        return ans;
    }
    public static void main(String args []){
        ContinuousSumQuery R1=new ContinuousSumQuery();
        int B[][] = new int[3][3];
        B[0][0]=1;B[0][1]= 2;B[0][2]= 10;
        B[1][0]=2;B[1][1]= 3;B[1][2]= 20;
        B[2][0]=2;B[2][1]= 5;B[2][2]= 25;
        System.out.println(R1.solve(5,B));
    }
}

