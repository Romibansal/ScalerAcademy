package Advance_Trees_3_BST;

//Q=Problem Description
//        Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
//
//        Note - If there are multiple options, always replace a node by its in-order predecessor
//
//
//        Problem Constraints
//        2 <= No. of nodes in BST <= 105
//        1 <= value of nodes <= 109
//        Each node has a unique value
//
//
//        Input Format
//        The first argument is the root node of a Binary Search Tree A.
//        The second argument is the value B.
//
//
//        Output Format
//        Delete the given node if found and return the root of the BST.
//
//
//        Example Input
//        Input 1:
//
//        15
//      /    \
//     12      20
//     / \    /  \
//    10  14  16  27
//   /
//  8
//
//        B = 10
//
//        Input 2:
//
//        8
//       / \
//      6  21
//     / \
//    1   7
//
//        B = 6
//
//
//
//        Example Output
//
//        Output 1:
//
//        15
//      /    \
//    12      20
//   / \    /  \
//  8  14  16  27
//
//        Output 2:
//
//        8
//       / \
//      1  21
//       \
//        7
//
//
//
//        Example Explanation

//        Explanation 1:
//
//        Node with value 10 is deleted

//        Explanation 2:
//
//        Node with value 6 is deleted

public class DeleteANodeInBST {
    public TreeNode solve(TreeNode A, int B) {
        TreeNode temp=A;
        TreeNode parent=null;
        while(temp.val!=B){
            if(temp==null){
                break;
            }
            parent=temp;
            if(temp.val<B){
                temp=temp.right;
            }
            else{
                temp=temp.left;
            }
        }
        if(temp==null){
            return A;
        }
        if(temp.right==null && temp.left==null){
            if(parent==null){
                return null;
            }
            if(parent.val<temp.val){
                parent.right=null;
            }
            else {
                parent.left=null;
            }
            return A;
        }
        else if(temp.left==null){
            if(parent==null){
                return temp.right;
            }
            if(parent.val< temp.val){
                parent.right=temp.right;
            }
            else{
                parent.left=temp.right;
            }
            return  A;
        }
        else if(temp.right==null){
            if(parent==null){
                return temp.left;
            }
            if(parent.val< temp.val){
                parent.right=temp.left;
            }
            else{
                parent.left=temp.left;
            }
            return  A;
        }
        else{
            TreeNode x=temp.left;
            while(x.right!=null){
                x=x.right;
            }
            TreeNode root=solve(A,x.val);
            x.left=temp.left;
            x.right=temp.right;
            if(parent==null){
                return  x;
            }
            if(parent.val< temp.val){
                parent.right=x;
            }
            else{
                parent.left=x;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        DeleteANodeInBST I = new DeleteANodeInBST();
        TreeNode A=new TreeNode(10);
        TreeNode A1=new TreeNode(9);
        TreeNode A2=new TreeNode(20);
        A.left=A1;
        A.right=A2;
        System.out.println(I.solve(A,19));
    }
}

