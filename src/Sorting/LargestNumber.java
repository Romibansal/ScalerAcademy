package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class largenummbercomparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        String s1=Integer.toString(o1);
        String s2=Integer.toString(o2);
        String s1s2=s1+s2;
        String s2s1=s2+s1;
        long j=Long.parseLong(s1s2);
        long i=Long.parseLong(s2s1);
        if(j<i){
            return 1;
        }
        return -1;
    }
}
public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        ArrayList<Integer> B=new ArrayList<>(A.size());
        for(int i=0;i<A.size();i++){
            B.add(A.get(i));
        }
        Collections.sort(B,new largenummbercomparator());
        String result="";
        for(int j=0;j<B.size();j++){
            String s="";
            s=Integer.toString(B.get(j));
            result=result+s;
        }
        int h=0;
        while(result.charAt(h)=='0'){
            result=(result.substring(0,h)+result.substring(h+1));
            if(result.matches("0")){
                return result;
            }
        }
        return result;
    }
    public static void main(String args []){
        LargestNumber N1=new LargestNumber();
        ArrayList<Integer>A=new ArrayList<>(4);
        A.add(3); A.add(30); A.add(34); A.add(5);A.add(9);

        System.out.println( N1.largestNumber(A));
    }
}
