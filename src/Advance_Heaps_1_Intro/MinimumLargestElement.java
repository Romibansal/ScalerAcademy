package Advance_Heaps_1_Intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
//
//Q=Problem Description

//        Given an array A of N numbers, you have to perform B operations.
//        In each operation, you have to pick any one of the N elements and add the original
//        value(value stored at the index before we did any operations) to its current value.
//        You can choose any of the N elements in each operation.
//
//        Perform B operations in such a way that the largest element of the
//        modified array(after B operations) is minimized.

//        Find the minimum possible largest element after B operations.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^6
//        0 <= B <= 10^5
//        -10^5 <= A[i] <= 10^5
//
//
//
//        Input Format

//        The first argument is an integer array A.
//        The second argument is an integer B.
//
//
//
//        Output Format

//        Return an integer denoting the minimum possible largest element after B operations.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 3, 4]
//        B = 3

//        Input 2:
//
//        A = [5, 1, 4, 2]
//        B = 5
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        5
//
//
//        Example Explanation

//        Explanation 1:
//
//        Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
//        Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
//        Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
//        Minimum possible largest element after 3 operations is 4.

//        Explanation 2:
//
//        Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
//        Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
//        Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
//        Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
//        Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
//        Minimum possible largest element after 5 operations is 5.


public class MinimumLargestElement {
    class pair{
        int data;
        int idx;
        pair(int val,int index){
            data=val;
            idx=index;
        }
    }
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer>temp=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            temp.add(A.get(i));
        }
        PriorityQueue<pair> pQueue = new PriorityQueue<pair>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.data > o2.data ? 1 :(o1.data < o2.data ? -1 : 0);
            }
        });
        for(int i=0;i<temp.size();i++){
            pQueue.add(new pair((temp.get(i)+ A.get(i)),i));
        }
        pair p = pQueue.poll();
        int id = p.idx;
        int v=p.data;
        temp.set(id, v);
        B--;
        while(B>0){
            int n=A.get(id)+v;
            pQueue.add(new pair(n,id));
            p=pQueue.poll();
            id=p.idx;
            v=p.data;
            temp.set(id, v);
            B--;
        }
        int ans=temp.get(0);
        for(int i=0;i<temp.size();i++){
            ans=Math.max(ans, temp.get(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumLargestElement I = new MinimumLargestElement();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(5);A.add( 7);A.add( 8);
        System.out.println( I.solve(A,9));
    }
}


