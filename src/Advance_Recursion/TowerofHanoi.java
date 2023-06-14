package Advance_Recursion;

import java.util.ArrayList;

//Q=Problem Description
//        In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3
//        (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which
//        can slide onto any tower.
//        The puzzle starts with disks sorted in ascending order of size from top to bottom
//        (i.e., each disk sits on top of an even larger one).
//        You have the following constraints:
//
//        Only one disk can be moved at a time.
//        A disk is slid off the top of one tower onto another tower.
//        A disk cannot be placed on top of a smaller disk.
//        You have to find the solution to the Tower of Hanoi problem.
//        You have to return a 2D array of dimensions M x 3, where M is the minimum number of
//        moves needed to solve the problem.
//        In each row, there should be 3 integers (disk, start, end), where:
//
//        disk - number of the disk being moved
//        start - number of the tower from which the disk is being moved
//        end - number of the tower to which the disk is being moved
//
//
//        Problem Constraints
//        1 <= A <= 18

public class TowerofHanoi {
    ArrayList<ArrayList<Integer>> tower
            (int N, int start, int destination, int helper ,ArrayList<ArrayList<Integer>> ans){
        if(N==1){
            ArrayList<Integer> a=new ArrayList<>();
            a.add(N);
            a.add(start);
            a.add(destination);
            ans.add(a);
            return ans;
        }
        tower(N-1,start,helper,destination,ans);
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(N);a1.add(start);a1.add(destination);
        ans.add(a1);
        tower(N-1,helper,destination,start,ans);
        return ans;
    }
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> ans=new  ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans1=tower(A,1,3,2,ans);
        return ans1;
    }
    public static void main(String[] args) {
        TowerofHanoi I = new TowerofHanoi();
        System.out.println(I.towerOfHanoi(2));
    }
}




