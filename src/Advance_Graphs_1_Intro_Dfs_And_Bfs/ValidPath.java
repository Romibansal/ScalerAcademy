package Advance_Graphs_1_Intro_Dfs_And_Bfs;

//Q=Problem Description
//        There is a rectangle with left bottom as (0, 0) and right up as (x, y).
//
//        There are N circles such that their centers are inside the rectangle.
//
//        Radius of each circle is R. Now we need to find out if it is possible that we can move from
//        (0, 0) to (x, y) without touching any circle.
//
//        Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot
//        move outside the boundary of the rectangle at any point of time.
//
//
//
//        Problem Constraints

//        0 <= x , y, R <= 100
//
//        1 <= N <= 1000
//
//        Center of each circle would lie within the grid
//
//
//
//        Input Format

//        1st argument given is an Integer x , denoted by A in input.
//
//        2nd argument given is an Integer y, denoted by B in input.
//
//        3rd argument given is an Integer N, number of circles, denoted by C in input.
//
//        4th argument given is an Integer R, radius of each circle, denoted by D in input.
//
//        5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
//
//        6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
//
//
//
//        Output Format

//        Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
//
//
//
//        Example Input

//        Input 1:
//
//        x = 2
//        y = 3
//        N = 1
//        R = 1
//        A = [2]
//        B = [3]

//        Input 2:
//
//        x = 3
//        y = 3
//        N = 1
//        R = 1
//        A = [0]
//        B = [3]
//
//
//        Example Output

//        Output 1:
//
//        NO

//        Output 2:
//
//        YES
//
//
//        Example Explanation

//        Explanation 1:
//
//        There is NO valid path in this case

//        Explanation 2:
//
//        There is many valid paths in this case.
//        One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).

public class ValidPath {
    boolean method(int[][] path, int x,int y,int A,int B){
        if(x<0 || y>B){
            return false;
        }
        if(x>A || y<0){
            return false;
        }
        if(x==A && y==B){
            return true;
        }

        if(path[x][y]==2){
            return false;
        }

        if(path[x][y]==1){
            path[x][y]=2;
            if(method(path,x-1,y,A,B) || method(path,x-1,y+1,A,B) || method(path,x,y+1,A,B) ||
                    method(path,x+1,y+1,A,B) || method(path,x+1,y,A,B) || method(path,x+1,y-1,A,B) ||
                    method(path,x,y-1,A,B) || method(path,x-1,y-1,A,B)){
                return true;
            }
        }
        else{
            return false;
        }

        return false;
    }
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] path=new int[A+1][B+1];
        for(int i=0;i<path.length;i++){
            for(int j=0;j<path[0].length;j++){
                path[i][j]=1;
            }
        }
        int radius=D;
        for(int i=0;i<path.length;i++){
            for(int j=0;j<path[0].length;j++){
                for(int k=0;k<C;k++){
                    int x1=E[k];
                    int y1=F[k];
                    int x=i;
                    int y=j;
                    int X=Math.abs(x1-x);
                    int Y=Math.abs(y1-y);
                    double temp=(Math.pow(X,2)+Math.pow(Y,2));
                    double dis=Math.sqrt(temp);
                    if(dis<=radius){
                        path[i][j]=0;
                    }
                }
            }
        }
        if(path[0][0]==0 || path[A][B]==0){
            return "NO";
        }
        if(method(path,0,0,A,B)) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        ValidPath I = new ValidPath();
        int[]A=new int[3];
        int[]B=new int[3];
        A[0]=1;A[1]=0;A[2]=3;
        B[0]=3;B[1]=2;B[2]=1;
        System.out.println( I.solve(4,4,3,1,A,B));
    }
}

