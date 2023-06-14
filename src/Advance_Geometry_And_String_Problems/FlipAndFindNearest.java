package Advance_Geometry_And_String_Problems;

import java.util.ArrayList;
import java.util.TreeSet;

//Q=Problem Description
//        Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.
//
//        Each query has 2 integers :-
//
//        First integer denotes the type of query. Type of query can be either 1 or 2.
//        Second integer denotes index x.
//        If type = 1, Flip the value at index x.
//
//        If type = 2, Find the index of the nearest 1 to the left or right
//        of index x in the array. If there are multiple indices has the same distance from x,
//        return the index with the lower value. If there is no occurrence of 1 in the array, return -1.
//
//        Note :
//        We use 1-based indexing
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//
//        1 <= Q <= 10^5
//
//        1 <= B[i][0] <= 2
//
//        1 <= B[i][1] <= N

public class FlipAndFindNearest {
    public int[] solve(String A, int[][] B) {
        TreeSet treeSet = new TreeSet();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='1'){
                treeSet.add(i+1);
            }
        }
        for(int i=0;i<B.length;i++){
            if(B[i][0]==1){
                int index=B[i][1];
                if(treeSet.contains(index)){
                    treeSet.remove(index);

                }
                else{
                    treeSet.add(index);
                }
            }
            else{
                int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
                if(treeSet.ceiling(B[i][1])!=null){
                    right = (int) treeSet.ceiling(B[i][1]);
                }
                if(treeSet.floor(B[i][1]) != null){
                    left = (int) treeSet.floor(B[i][1]);
                }
                if(left == Integer.MIN_VALUE && right == Integer.MAX_VALUE){
                    ans.add(-1);
                }
                else if (left != Integer.MIN_VALUE && (B[i][1]) - left <= right - B[i][1]){
                    ans.add(left);
                }
                else{
                    ans.add(right);
                }
            }
        }
        int[] result =new int[ans.size()];
        for(int j=0;j<ans.size();j++){
            result[j]=ans.get(j);
        }
        return result;
    }


    public static void main(String[] args) {
        FlipAndFindNearest I = new FlipAndFindNearest();
        int[][]B=new int[8][2];
        B[0][0]=1;B[0][1]=3;
        B[1][0]=1;B[1][1]=3;
        B[2][0]=2;B[2][1]=4;
        B[3][0]=2;B[3][1]=2;
        B[4][0]=1;B[4][1]=1;
        B[5][0]=2;B[5][1]=3;
        B[6][0]=1;B[6][1]=5;
        B[7][0]=1;B[7][1]=5;
        System.out.println(I.solve("10010",B));
    }
}





