package String;


//
//Q=Problem Description
//        Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
//
//        Problem Constraints
//        1 <= |A| <= 1000

public class CountOccurrences {
    public int solve(String A) {
        int count=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='o'){
                int k=i-1;
                int j=i+1;
                if(k>=0 && j<A.length()){
                    if(A.charAt(k)=='b' && A.charAt(j)=='b'){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String args []){
        CountOccurrences N1=new CountOccurrences();
        System.out.println( N1.solve("abobc"));
    }
}

