package Basic_Questions;

//Q=Problem Description
//        You will be given an integer n. You need to return the count of prime numbers less than or equal to n.


public class CountOfPrimes {
    public int solve(int A) {
        int result=0;
        for(int i=2;i<=A;i++){
            int flag=0;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                result++;
            }
        }
        return result;
    }
    public static void main(String args []){
        CountOfPrimes N1=new CountOfPrimes();
        System.out.println( N1.solve(19));
    }
}
