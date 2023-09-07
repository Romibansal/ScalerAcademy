package Advance_Trees_4_LCA;


//Q=Problem Description
//        Given a binary search tree.
//        Return the distance between two nodes with given two keys B and C.
//        It may be assumed that both keys exist in BST.
//
//        NOTE: Distance between two nodes is number of edges between them.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 1000000
//
//        0 <= node values <= 10^9
//
//
//
//        Input Format
//        First argument is a root node of the binary tree, A.
//
//        Second argument is an integer B.
//
//        Third argument is an integer C.
//
//
//
//        Output Format
//        Return an integer denoting the distance between two nodes with given two keys B and C
//
//
//
//        Example Input
//        Input 1:
//
//
//        5
//       /   \
//      2     8
//     / \   / \
//    1   4 6   11
//
//        B = 2
//        C = 11
//
//        Input 2:
//
//        6
//       /   \
//      2     9
//     / \   / \
//    1   4 7   10
//
//        B = 2
//        C = 6

//        Example Output
//
//        Output 1:
//        3

//        Output 2:
//        1
//
//        Example Explanation
//
//        Explanation 1:
//
//        Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
//
//        Explanation 2:
//
//        Path between 2 and 6 is: 2 -> 6. Distance will be 1


public class DistanceBetweenNodesofBST {
    TreeNode lca(TreeNode A,int B,int C){
        while(A!=null){
            if(A.val<B && A.val<C){
                A=A.right;
            }
            else if(A.val>B && A.val>C){
                A=A.left;
            }
            else{
                return A;
            }
        }
        return A;
    }
    int find_element(TreeNode root,int B){
        int count =0;
        while(root!=null){
            if(root.val==B){
                return count;
            }
            if(root.val>B){
                root=root.left;
                count++;
            }
            else{
                root=root.right;
                count++;
            }
        }
        return -1;
    }
    public int solve(TreeNode A, int B, int C) {
        TreeNode root=lca(A,B,C);
        int count1=find_element(root,B);
        int count2=find_element(root,C);
        return count1+count2;
    }
    public static void main(String[] args) {
        DistanceBetweenNodesofBST I = new DistanceBetweenNodesofBST();
        TreeNode A=new TreeNode(5);
        TreeNode A1=new TreeNode(2);
        TreeNode A2=new TreeNode(8);
        A.left=A1;
        A.right=A2;
        TreeNode A3=new TreeNode(1);
        TreeNode A4=new TreeNode(4);
        A1.left=A3;A1.right=A4;

        TreeNode A5=new TreeNode(6);
        TreeNode A6=new TreeNode(11);
        A2.left=A5;A2.right=A6;


        System.out.println(I.solve(A,2,11));
    }
}



