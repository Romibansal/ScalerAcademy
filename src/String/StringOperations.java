package String;

//Q=Problem Description
//
//        Akash likes playing with strings. One day he thought of applying
//        following operations on the string in the given order:
//
//        Concatenate the string with itself.
//        Delete all the uppercase letters.
//        Replace each vowel with '#'.
//        You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
//
//        NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
//
//        Problem Constraints
//        1<=N<=100000


public class StringOperations {
    public String solve(String A) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='a' || A.charAt(i)=='e' || A.charAt(i)=='o' ||A.charAt(i)=='i' ||A.charAt(i)=='u'){
                str.append('#');
            }
            else if((int)A.charAt(i)>=97 && (int)A.charAt(i)<=122){
                str.append(A.charAt(i));
            }
        }
        return (str.toString()+str.toString());
    }
    public static void main(String args []){
        StringOperations N1=new StringOperations();
        System.out.println( N1.solve("AbcaZeoB"));
    }
}

