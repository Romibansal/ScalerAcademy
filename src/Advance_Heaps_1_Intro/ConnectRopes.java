package Advance_Heaps_1_Intro;

import java.util.ArrayList;
import java.util.Collections;


//Q=Problem Description
//        You are given an array A of integers that represent the lengths of ropes.
//
//        You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
//
//        Find and return the minimum cost to connect these ropes into one rope.
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 1000
//
//
//
//        Input Format
//        The only argument given is the integer array A.
//
//
//
//        Output Format

//        Return an integer denoting the minimum cost to connect these ropes into one rope.
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
//        33

//        Output 2:
//
//        182
//
//
//        Example Explanation

//        Explanation 1:
//
//        Given array A = [1, 2, 3, 4, 5].
//        Connect the ropes in the following manner:
//        1 + 2 = 3
//        3 + 3 = 6
//        4 + 5 = 9
//        6 + 9 = 15
//
//        So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

//        Explanation 2:
//
//        Given array A = [5, 17, 100, 11].
//        Connect the ropes in the following manner:
//        5 + 11 = 16
//        16 + 17 = 33
//        33 + 100 = 133
//
//        So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.


public class ConnectRopes {
    void heapify(ArrayList<Integer> A, int i){
        while(((2*i)+1)<A.size()){
            int x=Math.min(A.get(i),A.get((2*i)+1));
            if(((2*i)+2)<A.size()){
                x=Math.min(x,A.get((2*i)+2));
            }
            if(x==A.get(i)){
                break;
            }
            else if(x==A.get((2*i)+1)){
                int temp=A.get(i);
                A.set(i,A.get((2*i)+1));
                A.set(((2*i)+1),temp);
                i=(2*i)+1;
            }
            else{
                int temp=A.get(i);
                A.set(i,A.get((2*i)+2));
                A.set(((2*i)+2),temp);
                i=(2*i)+2;
            }
        }
    }
    int Extract_Min(ArrayList<Integer> A){
        int n=A.size();
        int temp=A.get(0);
        A.set(0,A.get(n-1));
        A.set(n-1,temp);
        int min_element=A.get(n-1);
        A.remove(n-1);
        heapify(A,0);
        return min_element;
    }
    void Insertion(ArrayList<Integer> A,int value){
        A.add(value);
        int i=A.size()-1;
        while(i>0){
            int p=(i-1)/2;
            if(A.get(p)>A.get(i)){
                int temp=A.get(p);
                A.set(p,A.get(i));
                A.set(i,temp);
                i=p;
            }
            else{
                break;
            }
        }
    }
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans = 0;
        while(true){
            int min_element1 = Extract_Min(A);
            int min_element2 = Extract_Min(A);
            ans = ans + min_element1 + min_element2;
            Insertion(A, (min_element2 + min_element1));
            if(A.size()==1){
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ConnectRopes I = new ConnectRopes();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 2);A.add( 3);A.add( 4);A.add( 5);
        System.out.println( I.solve(A));
    }
}

