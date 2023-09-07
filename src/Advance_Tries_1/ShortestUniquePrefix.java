package Advance_Tries_1;

import java.util.ArrayList;


//
//Q=Problem Description
//        Given a list of N words, find the shortest unique prefix to represent each word in the list.
//
//        NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
//
//
//
//        Problem Constraints
//        1 <= Sum of length of all words <= 10^6
//
//
//
//        Input Format
//        First and only argument is a string array of size N.
//
//
//
//        Output Format
//        Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
//
//
//
//        Example Input

//        Input 1:
//
//        A = ["zebra", "dog", "duck", "dove"]

//        Input 2:
//
//        A = ["apple", "ball", "cat"]
//
//
//        Example Output

//        Output 1:
//
//        ["z", "dog", "du", "dov"]

//        Output 2:
//
//        ["a", "b", "c"]
//
//
//        Example Explanation

//        Explanation 1:
//
//        Shortest unique prefix of each word is:
//        For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
//        For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
//        For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
//        For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".
//
//        Explanation 2:
//
//        "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.


class Node{
    char data;
    Node[] children;
    boolean eow;
    int count;
    Node(char ch){
        count=0;
        data=ch;
        eow=false;
        children=new Node[26];
    }
}

public class ShortestUniquePrefix {
    void insert(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node(word.charAt(i));
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    void inserting_count(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]!=null){
                curr.children[idx].count=curr.children[idx].count+1;
            }
            curr=curr.children[idx];
        }
    }
    void search(Node root,String word){
        Node curr=root;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<word.length();i++){
            str.append(word.charAt(i));
            int idx=word.charAt(i)-'a';
            if(curr.children[idx].count==1){
                break;
            }
            curr=curr.children[idx];
        }
        ans.add(str.toString());
    }
    ArrayList<String>ans=new ArrayList<>();
    public ArrayList<String> prefix(ArrayList<String> A) {

        Node root=new Node('R');
        for(int i=0;i<A.size();i++){
            insert(root,A.get(i));
        }
        for(int i=0;i<A.size();i++){
            inserting_count(root,A.get(i));
        }
        for(int i=0;i<A.size();i++){
            search(root,A.get(i));
        }
        return  ans;
    }
    public static void main(String[] args) {
        ShortestUniquePrefix I = new ShortestUniquePrefix();
        ArrayList<String>A=new ArrayList<>();
        A.add("zebra");A.add( "dog");A.add( "duck");A.add( "dove");

        System.out.println( I.prefix(A));
    }
}



