package Advance_Tries_2_Trie_of_bits_And_Questions;

import java.util.ArrayList;


//Q=Problem Description
//        Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with
//        1<=L<=R<=N, which has maximum XOR value.
//
//        NOTE: If there are multiple subarrays with the same maximum value, return the subarray
//        with minimum length. If the length is the same, return the subarray with the minimum starting index.
//
//
//
//        Problem Constraints
//        1 <= N <= 100000
//        0 <= A[i] <= 10^9
//
//
//
//        Input Format

//        First and only argument is an integer array A.
//
//
//
//        Output Format

//        Return an integer array B of size 2. B[0] is the starting index(1-based)
//        of the subarray and B[1] is the ending index(1-based) of the subarray.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 4, 3]

//        Input 2:
//
//        A = [8]
//
//
//        Example Output

//        Output 1:
//
//        [2, 3]

//        Output 2:
//
//        [1, 1]
//
//
//        Example Explanation

//        Explanation 1:
//
//        There are 6 possible subarrays of A:
//        subarray            XOR value
//        [1]                     1
//        [4]                     4
//        [3]                     3
//        [1, 4]                  5 (1^4)
//        [4, 3]                  7 (4^3)
//        [1, 4, 3]               6 (1^4^3)
//
//        [4, 3] subarray has maximum XOR value. So, return [2, 3].

//        Explanation 2:
//
//        There is only one element in the array. So, the maximum XOR value
//        is equal to 8 and the only possible subarray is [1, 1].


public class MaximumXORSubarray {
    class Node{
        int idx;
        int data;
        Node[] children;

        Node(int val){
            data=val;
            children=new Node[2];
        }
    }
    void Insert(Node root, int value,int  id){
        Node curr=root;
        for(int i=30;i>-1;i--){

            int bit= (value>>i) & 1;
            if(curr.children[bit]==null){
                curr.children[bit]=new Node(bit);
            }
            curr=curr.children[bit];
        }
        curr.data=value;
        curr.idx=id;
    }
    ArrayList<Integer> Search(Node root, int val){
        Node curr=root;
        for(int i=30;i>-1;i--){
            int bit=(val>>i)&1;
            if(bit==1){
                if(curr.children[0]!=null){
                    curr= curr.children[0];
                }
                else{
                    curr=curr.children[1];
                }
            }
            else{
                if(curr.children[1]!=null){
                    curr= curr.children[1];
                }
                else {
                    curr=curr.children[0];
                }
            }
        }
        ArrayList<Integer>a=new ArrayList<>();
        a.add(curr.data);a.add(curr.idx);
        return a;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> px=new ArrayList<>();
        px.add(A.get(0));
        for(int i=1;i<A.size();i++){
            int xor=px.get(i-1)^A.get(i);
            px.add(xor);
        }
        int l=0;
        int r=0;
        int ans=px.get(0);
        for(int i=0;i<px.size();i++){
            if(px.get(i)>ans){
                ans=px.get(i);
                r=i;
            }
        }
        for(int i=0;i<px.size();i++){
            if(A.get(i)>ans){
                ans=A.get(i);
                r=i;l=i;
            }
        }
        Node root=new Node(-1);
        Insert(root,px.get(0),0);
        for(int i=1;i<px.size();i++){
            ArrayList a=Search(root,px.get(i));
            int best_sol= (int) a.get(0);
            if(ans<(best_sol^px.get(i)) ){

                ans=(best_sol^px.get(i));

                l=(int)a.get(1)+1;

                r=i;
            }
            else if(ans==(best_sol^px.get(i))){
                int temp_l=(int)a.get(1)+1;
                int temp_r=i;
                if((temp_r-temp_l+1)<(r-l+1)){
                    r=temp_r;
                    l=temp_l;
                }
            }
            Insert(root,px.get(i),i);
        }
        ArrayList<Integer>result =new ArrayList<>();
        result.add(l+1);
        result.add(r+1);
        return  result;
    }
    public static void main(String[] args) {
        MaximumXORSubarray I = new MaximumXORSubarray();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(33);A.add( 34);A.add( 14);
        A.add(10);A.add( 16);A.add( 23);
        A.add(31);A.add( 8);A.add( 32);
        System.out.println( I.solve(A));
    }
}