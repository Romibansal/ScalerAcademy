package Advance_Queues_Implementation_Problems;

import java.util.ArrayDeque;
import java.util.Deque;




//Q=Problem Description
//        Given an integer A, you have to find the Ath Perfect Number.
//
//        A Perfect Number has the following properties:
//
//        It comprises only 1 and 2.
//        The number of digits in a Perfect number is even.
//        It is a palindrome number.
//        For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
//
//
//
//        Problem Constraints
//        1 <= A <= 100000

//Example Input
//        Input 1:
//
//        A = 2
//        Input 2:
//
//        A = 3
//
//
//        Example Output
//        Output 1:
//
//        22
//        Output 2:
//
//        1111
//
//
//        Example Explanation
//        Explanation 1:
//
//        First four perfect numbers are:
//        1. 11
//        2. 22
//        3. 1111
//        4. 1221
//        Return the 2nd Perfect number.
//        Explanation 2:
//
//        First four perfect numbers are:
//        1. 11
//        2. 22
//        3. 1111
//        4. 1221
//        Return the 3rd Perfect number.

public class PerfectNumbers {

    public String solve(int A) {
        Deque<String> q=new ArrayDeque<>();
        if(A==1){
            return "11";
        }
        if(A==2){
            return "22";
        }
        q.addLast("1");
        q.addLast("2");
        int i=2;
        while(true){
            String s=q.removeFirst();
            String str=new String(s);
            str=str+'1';
            q.addLast(str);
            i++;
            if(i==A){
                StringBuilder a=new StringBuilder(str);
                a.reverse();
                return (str+a);

            }
            String str1=new String(s);
            str1=str1+'2';
            q.addLast(str1);
            i++;
            if(i==A){
                StringBuilder a=new StringBuilder(str1);
                a.reverse();
                return (str1+a);

            }
        }
    }
    public static void main(String[] args) {
        PerfectNumbers I = new PerfectNumbers();
        System.out.println(I.solve(4));
    }
}



