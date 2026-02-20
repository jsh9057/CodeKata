package com.sparta.day0220;

import java.util.LinkedList;
import java.util.Queue;

public class q124 {
    public int solution(String[] maps) {
        int answer = 0;
        int[] L = new int[2];
        int[] E = new int[2];
        int[] S = new int[2];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='E'){
                    E[0]=i;
                    E[1]=j;
                }
                else if(maps[i].charAt(j)=='L'){
                    L[0]=i;
                    L[1]=j;
                }
                else if(maps[i].charAt(j)=='S'){
                    S[0]=i;
                    S[1]=j;
                }
            }
        }

        int move = 0;
        move = bfs(maps, S, L);
        // System.out.println("1:"+move);
        if(move == -1){ return -1; }
        answer += move;


        move = bfs(maps, L, E);
        // System.out.println("2:"+move);
        if(move == -1){ return -1; }
        answer += move;

        return answer;
    }

    int bfs(String [] maps, int from[], int to[]){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();

        visit[from[0]][from[1]] = true;
        q.add(new int[]{from[0],from[1],0});

        while(!q.isEmpty()){
            int[] xy = q.poll();
            if(xy[0]==to[0] && xy[1]==to[1]){
                return xy[2];
            }

            for(int i=0;i<4;i++){
                int nx = dx[i]+xy[0];
                int ny = dy[i]+xy[1];

                if(!(0 <= nx && nx < maps.length)){ continue; }
                if(!(0 <= ny && ny < maps[0].length())){ continue; }
                if(maps[nx].charAt(ny)=='X' || visit[nx][ny]){ continue; }
                else {
                    q.add(new int[]{nx,ny,xy[2]+1});
                    visit[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}
