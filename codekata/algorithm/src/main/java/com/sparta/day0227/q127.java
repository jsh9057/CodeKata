package com.sparta.day0227;

import java.util.*;

public class q127 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(String[] board) {
        int answer = 0;
        Queue<Integer[]> q = new LinkedList<>();
        int[] start = new int[2];
        int[] goal = new int[2];
        int[][] move =  new int[board.length][board[0].length()];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j)=='R'){
                    start[0]=i;
                    start[1]=j;
                }
                else if(board[i].charAt(j)=='G'){
                    goal[0]=i;
                    goal[1]=j;
                }
            }
        }

        // y,x
        // System.out.println("start: "+start[0]+", "+start[1]);
        q.add(new Integer[]{start[0],start[1]});

        while(!q.isEmpty()){
            Integer[] now = q.poll();
            int y = now[0];
            int x = now[1];

            if(y == goal[0] && x == goal[1]){
                return move[y][x];
            }
            for(int i=0;i<4;i++){
                Integer[] ret = go(y,x,i,board);

                if(ret[0]==y && ret[1]==x){ continue; }
                if(move[ret[0]][ret[1]]==0){
                    move[ret[0]][ret[1]]=move[y][x]+1;
                    q.add(new Integer[]{ret[0],ret[1]});
                }
                else{
                    if(move[ret[0]][ret[1]]>move[y][x]+1){
                        move[ret[0]][ret[1]]=move[y][x]+1;
                        q.add(new Integer[]{ret[0],ret[1]});
                    }
                }
            }
        }
        return -1;
    }

    Integer[] go(int y, int x,int dir, String[] board){
        int ny=y;
        int nx=x;
        // System.out.println("go: "+y+","+x+" /dir:"+dir);
        while(true){
            ny= ny + dy[dir];
            nx= nx + dx[dir];
            // System.out.println("ing: "+(ny)+","+(nx));
            if(!isRange(ny,nx,board.length,board[0].length())){
                // System.out.println("end: "+(ny-dy[dir])+","+(nx-dx[dir]));
                return new Integer[]{ny-dy[dir],nx-dx[dir]};
            }
            if(isRange(ny,nx,board.length,board[0].length()))
                if(board[ny].charAt(nx) == 'D'){
                    // System.out.println("end: "+(ny-dy[dir])+","+(nx-dx[dir]));
                    return new Integer[]{ny-dy[dir],nx-dx[dir]};
                }
        }
    }
    boolean isRange(int y, int x, int my, int mx){
        return 0<=y && y<my && 0<=x && x<mx;
    }
}
