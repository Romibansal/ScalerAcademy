package Advance_Backtracking_2;

import java.util.ArrayList;

class node_trie{
    char data;
    boolean eow;
    node_trie children[];
    node_trie(char ch){
        data=ch;
        children=new node_trie[26];
        eow=false;
    }
}

public class WordBreak {

    boolean is_Present(String str,node_trie root){
        node_trie curr=root;
        for(int i=0;i<str.length();i++){
            int index=str.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return curr.eow;
    }
    boolean permutation(String A, node_trie root,int index){
        if(index==A.length()){
            return true;
        }
        for(int i=index;i<A.length();i++){
            String s=A.substring(index,i+1);
            if(s.length()>20){
                return false;
            }
            if(is_Present(s,root)){
                if(permutation(A,root,i+1)){
                    return true;
                }
            }
        }
        return false;
    }
    void insert(node_trie root, String word){
        node_trie curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new node_trie(word.charAt(i));
            }
            curr=curr.children[index];
        }
        curr.eow=true;
    }
    public int wordBreak(String A, ArrayList<String> B) {
        node_trie root=new node_trie('R');

        for(int i=0;i<B.size();i++){
            insert(root,B.get(i));
        }
        if(permutation(A,root,0)) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        WordBreak I = new WordBreak();
        ArrayList<String>B=new ArrayList<>();
        B.add("i"); B.add("ilik"); B.add("samsung"); B.add("esam");B.add("sung");B.add("sams");B.add("su");
        System.out.println( I.wordBreak("ilikesamsung",B));
    }
}


