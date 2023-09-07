package Advance_Queues_Implementation_Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;


//Q=Problem Description
//        Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
//        B is formed such that we have to find the first non-repeating character each time a character is inserted
//        to the stream and append it at the end to B. If no non-repeating character is found, append '#'
//        at the end of B.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000



//Example Input
//        Input 1:
//
//        A = "abadbc"
//
//        Input 2:
//
//        A = "abcabc"
//
//
//        Example Output
//
//        Output 1:
//
//        "aabbdd"
//
//        Output 2:
//
//        "aaabc#"
//
//
//        Example Explanation
//        Explanation 1:
//
//        "a"      -   first non repeating character 'a'
//        "ab"     -   first non repeating character 'a'
//        "aba"    -   first non repeating character 'b'
//        "abad"   -   first non repeating character 'b'
//        "abadb"  -   first non repeating character 'd'
//        "abadbc" -   first non repeating character 'd'
//        Explanation 2:
//
//        "a"      -   first non repeating character 'a'
//        "ab"     -   first non repeating character 'a'
//        "abc"    -   first non repeating character 'a'
//        "abca"   -   first non repeating character 'b'
//        "abcab"  -   first non repeating character 'c'
//        "abcabc" -   no non repeating character so '#'



public class FirstNonRepeatingCharacter {
    public String solve(String A) {
        Deque<Character> q=new ArrayDeque<>();
        StringBuilder str=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<A.length();i++){
            q.addLast(A.charAt(i));
            if(map.containsKey(A.charAt(i))) {
                int v = map.get(A.charAt(i));
                v++;
                map.put(A.charAt(i), v);
            }
            else {
                map.put(A.charAt(i),1);
            }
            while(!q.isEmpty()&& map.get(q.getFirst())>1){
                q.removeFirst();
            }
            if(q.isEmpty()){
                str.append('#');
            }
            else {
                str.append(q.getFirst());
            }

        }
        return  str.toString();
    }
    public static void main(String[] args) {
        FirstNonRepeatingCharacter I = new FirstNonRepeatingCharacter();

        System.out.println(I.solve( "eptexspxtsnmxxwzzyemldyhjfynha"));
    }
}



