package Advance_Trees_5_Problems_On_Trees;


//Q=Problem Description
//        Given a binary tree,
//
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.
//
//        Assume perfect binary tree.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 100000
//
//        0 <= node values <= 10^9
//
//
//
//        Input Format
//        First and only argument is head of the binary tree A.
//
//
//
//        Output Format
//        Return the head of the binary tree after the changes are made.
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
//        Input 2:
//
//
//        1
//       /  \
//      2    5
//     / \  / \
//    3  4  6  7
//
//
//        Example Output
//
//        Output 1:
//
//
//        1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//
//        Output 2:
//
//
//        1 -> NULL
//       /  \
//      2 -> 5 -> NULL
//     / \  / \
//    3->4->6->7 -> NULL
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Next pointers are set as given in the output.
//
//        Explanation 2:
//
//        Next pointers are set as given in the output.


class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class NextPointerBinaryTree {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr=root;
        while(curr!=null){
            TreeLinkNode temp=curr;
            while(temp!=null){
                if(temp.left!=null){
                    temp.left.next=temp.right;
                    if(temp.next!=null){
                        temp.right.next=temp.next.left;
                    }
                }
                temp=temp.next;
            }
            curr=curr.left;
        }
    }
    public static void main(String[] args) {
        NextPointerBinaryTree I = new NextPointerBinaryTree();
        TreeLinkNode A=new TreeLinkNode(1);
        TreeLinkNode A2=new TreeLinkNode(2);
        TreeLinkNode A3=new TreeLinkNode(3);
        A.left=A2;
        A.right=A3;
        TreeLinkNode A4=new TreeLinkNode(4);
        TreeLinkNode A5=new TreeLinkNode(5);
        A2.left=A4;
        A2.right=A5;
        TreeLinkNode A6=new TreeLinkNode(6);
        TreeLinkNode A7=new TreeLinkNode(7);
        TreeLinkNode A8=new TreeLinkNode(8);
        A3.right=A6;
        A6.left=A7;
        A6.right=A8;
         I.connect(A);
    }
}



