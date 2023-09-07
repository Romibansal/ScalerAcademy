package Advance_Tries_1;


import java.util.ArrayList;

//Q=Problem Description
//        Given an array of words A (dictionary) and another array B (which contain some words).
//
//        You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is
//        present in the dictionary and 0 denotes it is not present.
//
//        Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
//
//        Such problems can be seen in real life when we work on any online editor (like Google Documnet),
//        if the word is not valid it is underlined by a red line.
//
//        NOTE: Try to do this in O(n) time complexity.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 1000
//
//        1 <= sum of all strings in A <= 50000
//
//        1 <= |B| <= 1000
//
//
//
//        Input Format
//        First argument is array of strings A.
//
//        First argument is array of strings B.
//
//
//
//        Output Format

//        Return the binary array of integers according to the given format.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [ "hat", "cat", "rat" ]
//        B = [ "cat", "ball" ]

//        Input 2:
//
//        A = [ "tape", "bcci" ]
//        B = [ "table", "cci" ]
//
//
//        Example Output

//        Output 1:
//
//        [1, 0]

//        Output 2:
//
//        [0, 0]
//
//
//        Example Explanation

//        Explanation 1:
//
//        Only "cat" is present in the dictionary.

//        Explanation 2:
//
//        None of the words are present in the dictionary.

public class SpellingChecker {
    class Node{
        char data;
        boolean eow;
        Node[] children;
        Node(char ch){
            data=ch;
            eow=false;
            children=new Node[26];
        }
    }
    void Insert(Node root,String word){
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
    void Search(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                ans.add(0);
                return;
            }
            curr=curr.children[idx];
        }
        if(curr.eow==true){
            ans.add(1);
        }
        else{
            ans.add(0);
        }
        return;
    }
    ArrayList<Integer> ans=new ArrayList<>();
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        Node root=new Node('R');
        for(int i=0;i<A.size();i++){
            Insert(root,A.get(i));
        }
        for(int j=0;j<B.size();j++){
            Search(root,B.get(j));
        }
        return ans;
    }
    public static void main(String[] args) {
        SpellingChecker I = new SpellingChecker();
        ArrayList<String>A=new ArrayList<>();
        A.add("a");A.add("b");
        ArrayList<String>B=new ArrayList<>();
        B.add("a");B.add("b");
        System.out.println( I.solve(A,B));
    }
}



