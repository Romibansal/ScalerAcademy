package Advance_Graphs_2_Topological_Sort_And_DSU;


import java.util.HashSet;

public class GymTrainer {
    int root(int x, int[] parent_array){
        while(x!=parent_array[x]){
            x=parent_array[x];
        }
        return x;
    }
    void union(int x,int y,int[] parent_array){
        int rx=root(x,parent_array);
        int ry=root(y,parent_array);
        if(rx!=ry){
            parent_array[ry]=rx;
        }
    }
    public int solve(int A, int[][] B, int[][] C) {
        int[] parent_array=new int[A+1];
        for(int i=1;i<=A;i++){
            parent_array[i]=i;
        }
        for(int i=0;i<B.length;i++){
            union(B[i][0],B[i][1],parent_array);
        }
        for(int i=0;i<C.length;i++){
            union(C[i][0],C[i][1],parent_array);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<parent_array.length;i++){
            set.add(parent_array[i]);
        }
        if(set.size()==1){
            return -1;
        }
        return (int)Math.pow(2,set.size());
    }
    public static void main(String[] args) {
        GymTrainer I = new GymTrainer();
        int[][]B=new int[4][2];
        B[0][0]=1;B[0][1]=2;
        B[1][0]=1;B[1][1]=3;
        B[2][0]=4;B[2][1]=5;
        B[3][0]=4;B[3][1]=6;
        int[][] C=new int[4][2];
        C[0][0]=7;C[0][1]=8;
        C[1][0]=9;C[1][1]=10;
        C[2][0]=9;C[2][1]=11;
        C[3][0]=11;C[3][1]=10;
        System.out.println( I.solve(11,B,C));
    }
}

