package Basic_Questions;

//Q=Given two integers A and B. A represents the count of mangoes and B represent the count of slices of mangoes.
//        Mango can be cut into three slices of mangoes. A glass of mango shake can be formed by two slices of mangoes.
//
//        Find the maximum number of glasses of mango shakes you can make with A mangoes and B slices of mangoes initially.

public class MakeItSimpleMaths {
    public int solve(int A, int B) {
        return ((A*3)+B)/2;
    }
    public static void main(String args []){
        MakeItSimpleMaths N1=new MakeItSimpleMaths();
        System.out.println( N1.solve(7,1));
    }
}
