package Unique_Questions;


//Q=There are A people standing in a circle.
//        Person 1 kills their immediate clockwise neighbour and pass the knife to the next person standing in circle.
//        This process continues till there is only 1 person remaining. Find the last person standing in the circle.

public class JosephusProblemUsingLog {
    public int solve(int A) {
        int x=(int)(Math.log(A)/Math.log(2));
        int q=A-(int)Math.pow(2,x);
        return ((q*2)+1);
    }
    public static void main(String args []){
        JosephusProblemUsingLog N1=new JosephusProblemUsingLog();
        System.out.println( N1.solve(5));
    }
}


