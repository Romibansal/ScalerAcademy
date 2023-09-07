package Advance_Heaps_2_Questions;
//
//Q=Problem Description
//        Max Heap is a special kind of complete binary tree in which, for every node,
//        the value present in that node is greater than the value present in its children nodes.
//
//        Find the number of distinct Max Heap that can be made from A distinct integers.
//
//        In short, you have to ensure the following properties for the max heap :
//
//        Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level,
//        except possibly the last, is completely filled, and all nodes are as far left as possible.)
//        Every node is greater than all its children.

//        NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.
//
//
//
//        Problem Constraints
//        1 <= A <= 100
//
//
//
//        Input Format

//        The first and only argument is an integer A.
//
//
//
//        Output Format
//        Return an integer denoting the number of distinct Max Heap.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 4

//        Input 2:
//
//        A = 10
//
//
//        Example Output

//        Output 1:
//
//        3

//        Output 2:
//
//        3360
//
//
//        Example Explanation

//        Explanation 1:
//
//        Let us take 1, 2, 3, 4 as our 4 distinct integers

//        Following are the 3 possible max heaps from these 4 numbers :
//        4            4                     4
//       /  \         / \                   / \
//      3    2   ,   2   3      and        3   1
//     /            /                     /
//    1            1                     2

//        Explanation 2:
//
//        Number of distinct heaps possible with 10 distinct integers = 3360.

public class WaysToFormMaxHeap {
    public long ways(int n){
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int height = (int) (Math.log(n)/Math.log(2));
        //l+r = n-1
        int l = findleftSubtreeNodesCount(n, height);
        int r = n-1-l;
        // System.out.println("ncr = " + findNCR(n-1,l));
        return (findNCR(n-1,l)%mod * ways(l)%mod * ways(r)%mod)%mod;
    }
    int mod = 1000000007;
    public int solve(int A) {
        //formulae = (A-1)C(l) * ways(l) * ways(r)
        return (int)ways(A) % mod;
    }

    public int findleftSubtreeNodesCount(int n, int height){//n is total number of nodes
        int total_Nodes_Except_LastLevel = (1<<height)-1; // 2^height - 1
        int nodes_In_LastLevel = n - total_Nodes_Except_LastLevel; // n-((2^h)-1)
        int left_Nodes_Count_Except_LastLevel = (total_Nodes_Except_LastLevel - 1) / 2;
        int left_Nodes_Count_At_LastLevel = Math.min((1<<(height-1)), nodes_In_LastLevel);

        return (left_Nodes_Count_Except_LastLevel + left_Nodes_Count_At_LastLevel);
    }

    public int findNCR(int A, int B){
        if(A == B)
            return 1;
        int[][] combinations = new int[A+1][B+1];
        //filling the first column
        for(int i = 0; i <= A; i++) {
            combinations[i][0] = 1;
        }
        //rest of the matrix
        for(int i = 1; i <= A; i++){
            for(int j = 1; j <= B; j++){
                if(i == j) {
                    combinations[i][j] = 1;
                }
                else if(j > i) {
                    combinations[i][j] = 0;
                }
                else{
                    int sum = (combinations[i-1][j-1] + combinations[i-1][j])%mod;
                    combinations[i][j] = sum;
                }
            }
        }
        return combinations[A][B] % mod;
    }


    public static void main(String[] args) {
        WaysToFormMaxHeap I = new WaysToFormMaxHeap();

        System.out.println( I.solve(10));
    }
}


