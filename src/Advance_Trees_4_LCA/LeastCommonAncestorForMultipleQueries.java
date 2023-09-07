package Advance_Trees_4_LCA;

import java.util.HashMap;

public class LeastCommonAncestorForMultipleQueries {
    class pair{
        int in;
        int out;
        pair(){
            in=-1;
            out=-1;
        }
    }
    int time=0;
    HashMap<Integer,pair>map=new HashMap<>();
    void postorder(TreeNode A){
        if(A==null){
            return;
        }
        if(!map.containsKey(A.val)){
            pair p=new pair();
            p.in=time;
            time++;
            map.put(A.val,p);
        }

        postorder(A.left);
        postorder(A.right);

        pair p1=map.get(A.val);
        p1.out=time;
        map.put(A.val,p1);
        time++;
    }
    boolean ancestor(HashMap<Integer,pair> hm,int X,int Y){
        int inX	= hm.get(X).in;
        int inY = hm.get(Y).in;

        int outX = hm.get(X).out;
        int outY = hm.get(Y).out;

        return (inX < inY && outX > outY);
    }
    public int lca(TreeNode A, int B, int C) {
        postorder(A);
        TreeNode root=A;
        while(root!=null){
            if(root.left!=null &&  ancestor(map,root.left.val,C) && ancestor(map,root.left.val,B)){
                root=root.left;
            }
            else if(root.right!=null &&  ancestor(map,root.right.val,C) && ancestor(map,root.right.val,B)){
                root=root.right;
            }
            else{
                return root.val;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LeastCommonAncestorForMultipleQueries I = new LeastCommonAncestorForMultipleQueries();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);

        A.left=A1;
        A.right=A2;
        A2.left=A3;
        System.out.println(I.lca(A,2,3));
    }
}


