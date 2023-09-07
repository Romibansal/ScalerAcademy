package Advance_Trees_4_LCA;
//
//Q=Problem Description
//        Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
//
//        Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a
//        tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both
//        v and w as descendants.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000
//
//        1 <= B, C <= 10^9
//
//
//
//        Input Format
//        First argument is head of tree A.
//
//        Second argument is integer B.
//
//        Third argument is integer C.
//
//
//
//        Output Format
//        Return the LCA.
//
//
//
//        Example Input
//        Input 1:
//
//
//        1
//       /  \
//      2    3
//
//      B = 2
//      C = 3
//
//        Input 2:
//
//        1
//       /  \
//      2    3
//     / \
//    4   5
//
//    B = 4
//    C = 5
//
//
//        Example Output
//
//        Output 1:
//
//         1
//
//        Output 2:
//
//         2
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        LCA is 1.
//
//        Explanation 2:
//
//        LCA is 2.


public class LeastCommonAncestor {
    boolean find_node(TreeNode A,int B){
        if(A==null){
            return false;
        }
        if(A.val==B){
            return true;
        }
        boolean b1=find_node(A.left,B);
        boolean b2=find_node(A.right,B);
        if(b1 || b2){
            return true;
        }
        return false;
    }
    int traversal(TreeNode A, int B, int C){
        if(A==null){
            return -1;
        }
        if(A.val==B){
            return B;
        }
        if(A.val==C){
            return C;
        }
        int l=traversal(A.left,B,C);
        int r=traversal(A.right,B,C);
        if(l==-1 && r==-1){
            return -1;
        }
        if(l!=-1 && r!=-1){
            return A.val;
        }
        if(l!=-1){
            return l;
        }
        if(r!=-1){
            return r;
        }
        return -1;
    }
    public int lca(TreeNode A, int B, int C) {
        boolean b1=find_node(A,B);
        boolean b2=find_node(A,C);
        if(b1==false || b2==false){
            return -1;
        }
        if(B==C && A.val==B){
            return C;
        }
        int ans=traversal(A,B,C);
        return  ans;
    }
    public static void main(String[] args) {
        LeastCommonAncestor I = new LeastCommonAncestor();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(2);
        TreeNode A2=new TreeNode(3);
        A.left=A1;A.right=A2;
        TreeNode A3=new TreeNode(4);
        A1.left=A3;
        TreeNode A4=new TreeNode(5);
        TreeNode A5=new TreeNode(6);
        A2.left=A4;A2.right=A5;
        TreeNode A6=new TreeNode(7);
        A4.left=A6;
        TreeNode A7=new TreeNode(8);
        TreeNode A8=new TreeNode(9);
        A5.left=A7;
        A5.right=A8;

        System.out.println(I.lca(A,6,5));
    }
}



