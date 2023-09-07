package Advance_Queues_Implementation_Problems;

import java.util.ArrayDeque;
import java.util.Deque;


//Q=Problem Description
//        Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
//
//        NOTE: All the A integers will fit in 32-bit integers.
//
//
//
//        Problem Constraints
//        1 <= A <= 29500

//
//Example Input
//        Input 1:
//        A = 3
//        Input 2:
//        A = 7
//
//
//        Example Output
//        Output 1:
//
//        [1, 2, 3]
//        Output 2:
//
//        [1, 2, 3, 11, 12, 13, 21]

public class NIntegersContainingOnly123 {
    public int[] solve(int A) {
        int[] ans=new int[A];
        ans[0]=1;
        if(A==1){
            return ans;
        }
        ans[1]=2;
        if(A==2){
            return ans;
        }
        ans[2]=3;
        if(A==3){
            return ans;
        }
        Deque<Integer> q1=new ArrayDeque<>();
        q1.addLast(1);
        q1.addLast(2);
        q1.addLast(3);
        int i=3;
        while(i<=A-1){
            int element=q1.removeFirst();
            int new_element1=(element*10)+1;
            ans[i]=new_element1;

            q1.addLast(new_element1);

            if(i==A-1){
                return ans;
            }
            i++;
            int new_element2=(element*10)+2;
            ans[i]=new_element2;

            q1.addLast(new_element2);

            if(i==A-1){
                return ans;
            }
            i++;
            int new_element3=(element*10)+3;
            ans[i]=new_element3;

            q1.addLast(new_element3);

            if(i==A-1){
                return ans;
            }
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        NIntegersContainingOnly123 I = new NIntegersContainingOnly123();

        System.out.println(I.solve(15));
    }
}



