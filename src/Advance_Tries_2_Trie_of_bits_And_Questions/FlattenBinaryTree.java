package Advance_Tries_2_Trie_of_bits_And_Questions;

//
//Q=Problem Description
//        Given a binary tree A, flatten it to a linked list in-place.
//
//        The left child of all nodes should be NULL.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000
//
//
//
//        Input Format

//        First and only argument is the head of tree A.
//
//
//
//        Output Format

//        Return the linked-list after flattening.
//
//
//
//        Example Input

//        Input 1:
//
//        1
//       / \
//      2   3

//        Input 2:
//
//        1
//       / \
//      2   5
//     / \   \
//    3   4   6
//
//
//        Example Output

//        Output 1:
//
//        1
//         \
//          2
//           \
//            3

//        Output 2:
//
//        1
//         \
//          2
//           \
//            3
//             \
//              4
//               \
//                5
//                 \
//                  6
//
//
//        Example Explanation

//        Explanation 1:
//
//        Tree flattening looks like this.
//
//        Explanation 2:
//
//        Tree flattening looks like this.
//




public class FlattenBinaryTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x){
          val = x;
      }
  }
    static class node{
        TreeNode head;
        TreeNode tail;
        node(TreeNode h,TreeNode t){
            head=h;
            tail=t;
        }
    }

    public node flat(TreeNode a) {
        if(a==null){
            return null;
        }
        node l=flat(a.left);
        node r=flat(a.right);
        a.left=null;
        if(l==null && r==null){
            return (new node(a,a));
        }
        else if(l==null){
            a.right=r.head;
            return (new node(a,r.tail));
        }
        else if(r==null){
            a.right=l.head;
            return (new node(a,l.tail));
        }
        else{
            a.right=l.head;
            l.tail.right=r.head;
            return (new node(a,r.tail));
        }
    }
    public TreeNode flatten(TreeNode a) {
        node temp=flat(a);
        return a;
    }

    public static void main(String[] args) {
        FlattenBinaryTree I = new FlattenBinaryTree();
        TreeNode A=new TreeNode(1);
        TreeNode a1=new TreeNode(2);
        TreeNode a2=new TreeNode(5);
        A.left=a1;
        A.right=a2;

        TreeNode a3=new TreeNode(3);
        TreeNode a4=new TreeNode(4);
        a1.left=a3;
        a1.right=a4;

        TreeNode a5=new TreeNode(6);
        a2.right=a5;

        System.out.println(I.flatten(A));
    }
}

