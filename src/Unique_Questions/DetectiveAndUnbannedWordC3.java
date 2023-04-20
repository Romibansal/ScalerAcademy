package Unique_Questions;

import java.util.HashMap;

//Q=Sherlock is investigating a case and has a transcript of a conversation between the suspects.The detective needs to find
//out the most commonly used word in the conversation that is not on the list of banned words provided by the forensic team.
//
//The conversation transcript is a string array A of size N and the banned words are given in an string array B of size M.
//
//Write a program to return the most frequently used word in the conversation that is not on the banned list.If there is not
//on the banned list. If there are multiple words with the highest frequency ,return the lexicographically smallest one.
//
//Note: Return an empty string if all the words in the conversation are banned
//
//Problem Contraints:
//1<=N,M<=10^5
//1<=A[i],B[j]<=10
//A[i] and B[j] consists of lowercase english letters


public class DetectiveAndUnbannedWordC3 {
    public String solve(String[] A, String[] B) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v++;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        HashMap<String,Integer>hm1=new HashMap<>();
        for(int i=0;i<B.length;i++){
            if(hm1.containsKey(B[i])){
                int v1=hm1.get(B[i]);
                v1++;
                hm1.put(B[i],v1);
            }
            else{
                hm1.put(B[i],1);
            }
        }
        String ans="";
        int value=0;
        for(int j=0;j<A.length;j++){
            if(hm1.containsKey(A[j])){
                continue;
            }
            else{
                String temp=A[j];
                int tempvalue=hm.get(A[j]);
                if(ans==""){
                    ans=temp;
                    value=tempvalue;
                }
                else if(tempvalue>value){
                    ans=temp;
                    value=tempvalue;
                }
                else if(tempvalue==value){
                    int q=temp.compareTo(ans);
                    if(q<0){
                        ans=temp;
                        value=tempvalue;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String args []){
        DetectiveAndUnbannedWordC3 S1=new DetectiveAndUnbannedWordC3();
        String B[]=new String[2];
        B[0]="c";B[1]="b";
        String A[]=new String[9];
        A[0]="bb";A[2]="c";A[4]="ab";A[6]="cc";A[8]="a";
        A[1]="cc";A[3]="b";A[5]="b";A[7]="a";
        System.out.println( S1.solve(A,B));
    }
}


