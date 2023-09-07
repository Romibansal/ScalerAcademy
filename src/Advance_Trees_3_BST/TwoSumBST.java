package Advance_Trees_3_BST;


import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given a binary search tree A, where each node contains a positive integer,
//        and an integer B, you have to find whether or not there exist two different nodes
//        X and Y such that X.value + Y.value = B.
//
//        Return 1 to denote that two such nodes exist. Return 0, otherwise.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000
//
//        1 <= B <= 10^9
//
//
//
//        Input Format
//        First argument is the head of the tree A.
//
//        Second argument is the integer B.
//
//
//
//        Output Format
//        Return 1 if such a pair can be found, 0 otherwise.
//
//
//
//        Example Input

//        Input 1:
//
//        10
//       / \
//      9   20
//
//        B = 19

//        Input 2:
//
//
//        10
//       / \
//      9   20
//
//        B = 40
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        10 + 9 = 19. Hence 1 is returned.

//        Explanation 2:
//
//        No such pair exists.


public class TwoSumBST {
   // HashMap<Integer,Integer> map=new HashMap<>();
    ArrayList<Integer> a=new ArrayList<>();
    void tree_iterate(TreeNode A){
        if(A==null){
            return;
        }
        tree_iterate(A.left);
        tree_iterate(A.right);
        //map.put(A.val,1);
        a.add(A.val);
    }
    public int t2Sum(TreeNode A, int B) {
        tree_iterate(A);
//        for (int i=0;i<a.size();i++) {
//            if(map.containsKey(B-a.get(i)) && map.get(B-a.get(i))>=1){
//                return 1;
//            }
//        }
        Collections.sort(a);
        int i=0;
        int j=a.size()-1;
        while(i<j){
            int sum=a.get(i)+a.get(j);
            if(sum==B){
                return 1;
            }
            else if(sum>B){
                j--;
            }
            else{
                i++;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        TwoSumBST I = new TwoSumBST();
        TreeNode A=new TreeNode(10);
        TreeNode A1=new TreeNode(9);
        TreeNode A2=new TreeNode(20);
        A.left=A1;
        A.right=A2;
        System.out.println(I.t2Sum(A,19));
    }
}
