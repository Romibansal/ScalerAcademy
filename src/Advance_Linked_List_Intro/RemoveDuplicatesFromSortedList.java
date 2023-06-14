package Advance_Linked_List_Intro;

import java.util.HashSet;

//Q=Problem Description
//        Given a sorted linked list, delete all duplicates such that each element appears only once.
//
//
//
//        Problem Constraints
//        0 <= length of linked list <= 10^6

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        HashSet<Integer> set =new HashSet<>();
        ListNode temphead=A;
        ListNode prev=null;
        while(temphead!=null){
            if(set.contains(temphead.val)){
                prev.next=temphead.next;
                temphead=temphead.next;
            }
            else{
                set.add(temphead.val);
                prev=temphead;
                temphead=temphead.next;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList I = new RemoveDuplicatesFromSortedList();
        ListNode d = new ListNode(3) ;
        ListNode c = new ListNode(2) ;
        ListNode b = new ListNode(3) ;
        ListNode a = new ListNode(2) ;
        ListNode A=new ListNode(1);
        A.next=a;
        a.next=c;
        c.next=b;
        b.next=d;

        System.out.println(I.deleteDuplicates(A));
    }
}



