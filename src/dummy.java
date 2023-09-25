
import java.util.*;

public class dummy {
    boolean method(String s, String p,int i, int j){
        if(i<0 && j<0){
            return true;
        }
        if(j<0){
            return false;
        }
        if(i<0){
            for(int k=0;k<=j;k=k+2){
                if((k+1)>j || p.charAt(k+1)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i)==p.charAt(j) ){
            return method(s,p,i-1,j-1);
        }
        if(p.charAt(j)=='.'){
            return method(s,p,i-1,j-1);
        }
        if(p.charAt(j)=='*'){
            boolean temp1=false;
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                temp1=method(s,p,i-1,j);
            }

            return  temp1 ||  method(s,p,i,j-2);

        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        return method(s,p,s.length()-1,p.length()-1);
    }
    public static void main(String args[]) {
        dummy d1=new dummy();
        System.out.println(d1.isMatch("ab",".*"));
    }

}



