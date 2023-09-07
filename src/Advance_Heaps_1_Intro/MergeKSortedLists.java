package Advance_Heaps_1_Intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//
//Q=Problem Description
//        Given a list containing head pointers of N sorted linked lists.
//        Merge these given sorted linked lists and return them as one sorted list.
//
//
//
//        Problem Constraints

//        1 <= total number of elements in given linked lists <= 100000
//
//
//
//        Input Format

//        The first and only argument is a list containing N head pointers.
//
//
//
//        Output Format

//        Return a pointer to the head of the sorted linked list after merging all the given linked lists.
//
//
//
//        Example Input

//        Input 1:
//
//        1 -> 10 -> 20
//        4 -> 11 -> 13
//        3 -> 8 -> 9

//        Input 2:
//
//        10 -> 12
//        13
//        5 -> 6
//
//
//        Example Output

//        Output 1:
//
//        1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

//        Output 2:
//
//        5 -> 6 -> 10 -> 12 ->13
//
//
//        Example Explanation

//        Explanation 1:
//
//        The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.

//        Explanation 2:
//
//        The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

public class MergeKSortedLists {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  class node{
        ListNode l;
        int list;
        int val;
        node(int list1,ListNode l1,int val1){
            list=list1;
            l=l1.next;
            val=val1;
        }
  }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<node> pq=new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val > o2.val ? 1 :(o1.val < o2.val ? -1 : 0);
            }
        });
        for(int i=0;i<a.size();i++){
            pq.add(new node(i,a.get(i),a.get(i).val));
        }
        ListNode ans=null;
        ListNode temp=null;
        while (!pq.isEmpty()){
            node n=pq.poll();
            if(ans==null){
                ans=new ListNode(n.val);
                temp=ans;
            }
            else{
                temp.next=new ListNode(n.val);
                temp=temp.next;
            }
            int list_no=n.list;
            ListNode l=n.l;
            if(l!=null){
                pq.add(new node(list_no,l,l.val));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MergeKSortedLists I = new MergeKSortedLists();
        ArrayList<ListNode>A=new ArrayList<>();

        ListNode l1=new ListNode(1);
        l1.next=new ListNode(10);
        l1.next.next=new ListNode(20);


        ListNode l2=new ListNode(4);
        l2.next=new ListNode(11);
        l2.next.next=new ListNode(13);

        ListNode l3=new ListNode(3);
        l3.next=new ListNode(8);
        l3.next.next=new ListNode(9);

        A.add(l1);A.add( l2);A.add( l3);
        System.out.println( I.mergeKLists(A));
    }
}


