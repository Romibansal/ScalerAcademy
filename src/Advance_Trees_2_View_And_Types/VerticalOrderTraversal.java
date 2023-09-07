package Advance_Trees_2_View_And_Types;

//Q=Problem Description
//        Given a binary tree, return a 2-D array with vertical order traversal of it.
//        Go through the example and image for more details.
//
//
//        NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
//
//
//
//        Problem Constraints
//        0 <= number of nodes <= 10^5
//
//
//Example Input
//        Input 1:
//
//          6
//        /   \
//       3     7
//      / \     \
//     2   5     9
//        Input 2:
//
//         1
//       /   \
//      3     7
//     /       \
//    2         9
//
//Example Output
//        Output 1:
//
//        [
//        [2],
//        [3],
//        [6, 5],
//        [7],
//        [9]
//        ]
//        Output 2:
//
//        [
//        [2],
//        [3],
//        [1],
//        [7],
//        [9]
//        ]


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int vtlevel;

    Pair(TreeNode node, int vtlevel) {
        this.node = node;
        this.vtlevel = vtlevel;
    }
}
public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        int max=0;
        int min= 0;
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        Pair p=new Pair(A,0);
        q.add(p);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair remove = q.remove();
                TreeNode node = remove.node;
                int level = remove.vtlevel;
                max=Math.max(max,level);
                min=Math.min(min,level);
                if(map.containsKey(level)){
                    ArrayList a=map.get(level);
                    a.add(node.val);
                    map.put(level,a);
                }
                else{
                    ArrayList<Integer> n=new ArrayList<>();
                    n.add(node.val);
                    map.put(level,n);
                }
                if(node.left!=null){
                    Pair p1=new Pair(node.left,level-1);
                    q.add(p1);
                }
                if(node.right!=null){
                    Pair p1=new Pair(node.right,level+1);
                    q.add(p1);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            ArrayList<Integer>temp=new ArrayList<>();
            for(int j=0;j<map.get(i).size();j++){
                temp.add(map.get(i).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }
        public static void main(String[] args) {
            VerticalOrderTraversal I = new VerticalOrderTraversal();
            TreeNode A = new TreeNode(6);
            TreeNode A2 = new TreeNode(9);
            TreeNode A3 = new TreeNode(4);
            TreeNode A4 = new TreeNode(8);
            TreeNode A5 = new TreeNode(3);
            A.left = A2;
            A.right = A3;
            A3.left = A4;

            A4.right = A5;

            System.out.println(I.verticalOrderTraversal(A));
        }
    }
