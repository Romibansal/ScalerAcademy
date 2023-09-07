package Advance_Tries_1;

import java.util.*;

//
//Q=Problem Description
//        There is a dictionary A of N words, and ith word has a unique weight Wi.
//
//        Another string array B of size M contains the prefixes. For every prefix B[i],
//        output atmost 5 words from the dictionary A that start with the same prefix.
//
//        Output the words in decreasing order of their weight.
//
//        NOTE: If there is no word that starts with the given prefix output -1.
//
//
//
//        Problem Constraints
//        1 <= T <= 5
//
//        1 <= N <= 20000
//        1 <= M <= 10000
//
//        1 <= Wi <= 106
//
//        1 <= length of any string either in A or B <= 30
//
//
//
//        Input Format
//        First line is an integer T denoting the number of test cases.
//        For each test case,
//
//        First line denotes two space seperated integer N and M.
//        Second line denotes N space seperated strings denoting the words in dictionary.
//        Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
//        Fourth line denotes M space seperated integers denoting the prefixes.
//
//
//        Output Format
//        For every prefix B[i], print the space seperated output on a new line.
//
//        NOTE: After every output there should be a space.
//
//
//
//        Example Input
//        Input 1:
//
//        1
//        6 3
//        abcd aecd abaa abef acdcc acbcc
//        2 1 3 4 6 5
//        ab abc a

//        Input 2:
//
//        1
//        5 3
//        aaaa aacd abaa abaa aadcc
//        3 4 1 2 6
//        aa aba abc
//
//
//        Example Output

//        Output 1:
//
//        abef abaa abcd
//        abcd
//        acdcc acbcc abef abaa abcd

//        Output 2:
//
//        aadcc aacd aaaa
//        abaa abaa
//        -1
//
//
//        Example Explanation

//        Explanation 1:
//
//        For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4).
//        Ouput them in decreasing order of weight.
//        For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
//        For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3,
//        "abef" : 4, "acdcc" : 6, "acbcc" : 5).
//        Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
//
//        Explanation 2:
//
//        For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6).
//        Ouput them in decreasing order of weight.
//        For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
//        For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.


public class AutoComplete {
    class pair{
        int w;
        String word;
        pair(int we,String wor){
            w=we;
            word=wor;
        }
    }
    class Node{
        Character data;
        Node[] children;
        ArrayList<Integer> index;
        Node(char ch){
            data=ch;
            children=new Node[26];
            index=new ArrayList<>();

        }
    }
     void Insert(Node root,String word,int index){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                Node new_node =new Node(word.charAt(i));
                curr.children[idx]=new_node;
            }
            curr=curr.children[idx];
            if(curr.index.size()<5) {
                curr.index.add(index);
            }


        }


    }
     void Search(Node root,String pre,ArrayList words){
        Node curr=root;

        for(int i=0;i<pre.length();i++){
            int idx=pre.charAt(i)-'a';
            if(curr.children[idx]==null){
                System.out.print(-1+" ");
                return;
            }
            else{
                curr=curr.children[idx];
            }
        }
        int s=curr.index.size();
        for(int i=0;i<s;i++){
            System.out.print(words.get(curr.index.get(i))+" ");
        }
    }
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<String> words=new ArrayList<>();
            ArrayList<String> prefixes=new ArrayList<>();
            ArrayList<Integer> weights=new ArrayList<>();
            ArrayList<pair> P=new ArrayList<>();
            for (int j = 0; j < n; j++){
                words.add (sc.next());
            }

            for (int j = 0; j < n; j++) {
                weights.add( sc.nextInt());
            }

            for (int j = 0; j < m; j++){
                prefixes.add( sc.next());
            }
            for(int j=0;j<n;j++){
                P.add(new pair(weights.get(j),words.get(j)));
            }

            Collections.sort(P, new Comparator<pair>() {
                public int compare(pair o1, pair o2) {
                    if(o1.w<o2.w){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            });

            for(int j=0;j<n;j++){
                words.set(j,P.get(j).word);
            }

            Node root=new Node('r');
            for(int j=0;j<n;j++){
                Insert(root,words.get(j),j);

            }

            for(int k=0;k<prefixes.size();k++){
                Search(root,prefixes.get(k),words);
                System.out.println();
            }
        }
    }
}


