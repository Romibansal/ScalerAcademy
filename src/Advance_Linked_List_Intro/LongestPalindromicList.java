package Advance_Linked_List_Intro;

//Q=Problem Description
//        Given a linked list of integers. Find and return the length of
//        the longest palindrome list that exists in that linked list.
//
//        A palindrome list is a list that reads the same backward and forward.
//
//        Expected memory complexity : O(1)

//        Problem Constraints
//        1 <= length of the linked list <= 2000
//
//        1 <= Node value <= 100

public class LongestPalindromicList {
     int matchingCount(ListNode A,ListNode B){
         int count=0;
         while(A!=null && B!=null){
             if(A.val!= B.val){
                 break;
             }
             else {
                 count++;
                 A = A.next;
                 B = B.next;
             }
         }
         return count;
    }
    public int solve(ListNode A) {
        if(A.next == null) {
            return 1;
        }
        int even=0;
        int ans = 1;
       ListNode prev=null;
       ListNode curr=A;

       while(curr.next!=null){
           ListNode temp=curr.next;
           int odd=matchingCount(prev,temp);
           ans=Math.max(ans,((2*odd)+1));
           if(curr.val == temp.val){//for even
                even = matchingCount(prev,temp.next);
                ans = Math.max(ans,(2*even)+2);
            }
           curr.next=prev;
           prev=curr;
           curr=temp;
       }
       return ans;
    }
    public static void main(String[] args) {
        LongestPalindromicList I = new LongestPalindromicList();
        ListNode A=new ListNode(2);
        A.next=new ListNode(3);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(3);

        System.out.println(I.solve(A));
    }
}