package Advance_Tries_2_Trie_of_bits_And_Questions;

import java.util.ArrayList;

//
//Q=Problem Description
//        Given an array of integers A, find and return the maximum result of A[i] XOR A[j],
//        where i, j are the indexes of the array.
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        0 <= A[i] <= 10^9
//
//
//
//        Input Format

//        The only argument given is the integer array A.
//
//
//
//        Output Format

//        Return an integer denoting the maximum result of A[i] XOR A[j].
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 3, 4, 5]

//        Input 2:
//
//        A = [5, 17, 100, 11]
//
//
//        Example Output

//        Output 1:
//
//        7

//        Output 2:
//
//        117
//
//
//        Example Explanation

//        Explanation 1:
//
//        Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

//        Explanation 2:
//
//        Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.


class Node{
    int data;
    Node[] children;

    Node(int val){
        data=val;
        children=new Node[2];
    }
}

public class MaximumXOR {
    void Insert(Node root, int value){
        Node curr=root;
        for(int i=30;i>-1;i--){

            int bit= (value>>i) & 1;
            if(curr.children[bit]==null){
                curr.children[bit]=new Node(bit);
            }
            curr=curr.children[bit];
        }
        curr.data=value;
    }
    int Search(Node root, int val){
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
        return curr.data;
    }
    public int solve(ArrayList<Integer> A) {
        Node root=new Node(-1);
        Insert(root,A.get(0));
        int ans=0;
        for(int i=1;i<A.size();i++){
            int best_sol=Search(root,A.get(i));
            ans=Math.max(ans,best_sol^A.get(i));
            Insert(root,A.get(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        MaximumXOR I = new MaximumXOR();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(20);A.add( 30);A.add( 15);A.add( 25);A.add( 10);A.add( 5);
        System.out.println( I.solve(A));
    }
}
