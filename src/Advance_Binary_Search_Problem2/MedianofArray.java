package Advance_Binary_Search_Problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianofArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.size()<b.size()) return findMedianSortedArrays(b,a);
        int n1=a.size();
        int n2=b.size();
        if(n2==0){
            return (a.get((n1-1)/2) + (double)a.get(n1/2))/2.0;
        }
        //left of B r=right
        int l=0,r=n2;
        while(l<=r){
            int i1=(l+r)/2;  //array b
            int i2=(n1+n2+1)/2-i1; //array a
            //b
            int r1=(i1==n2)? Integer.MAX_VALUE : b.get(i1);
            int l1=(i1==0)? Integer.MIN_VALUE : b.get(i1-1);
            //a
            int r2=(i2==n1)? Integer.MAX_VALUE : a.get(i2);
            int l2=(i2==0)? Integer.MIN_VALUE : a.get(i2-1);
            if(Math.max(l1,l2)<=Math.min(r1,r2)){
                if((n1+n2)%2==0){
                    return (double) ( Math.max(l1,l2) + Math.min(r1,r2) )/2;
                }else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                r=i1-1;
            }else{
                l=i1+1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        MedianofArray I = new MedianofArray();
        ArrayList<Integer>a=new ArrayList<>();
        ArrayList<Integer>b=new ArrayList<>();
        a.add(-43);a.add(-25);
        a.add(-18);a.add(-15);
        a.add(-10);a.add(9);
        a.add(39);a.add(40);
        b.add(-2);

        System.out.println(I.findMedianSortedArrays(a,b));
    }
}