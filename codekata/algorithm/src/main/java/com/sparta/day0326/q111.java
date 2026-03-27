package com.sparta.day0326;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q111 {
    static boolean visit[][];

    public int[] solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='X'){ map[i][j]=-1; }
                else{ map[i][j]=maps[i].charAt(j)-'0'; }
            }
        }

        visit = new boolean[map.length][map[0].length];
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<map.length;i++){
            for(int j=0; j<map[0].length; j++){
                if(visit[i][j] || map[i][j]==-1){ continue; }
                total = dfs(i,j,map[i][j], map);
                if(total != 0){
                    list.add(total);
                }
            }
        }
        if(list.size()==0){ return new int[]{-1};}
        Collections.sort(list);
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }

        return ret;
    }

    int dfs(int y, int x, int now, int[][] map){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        visit[y][x]=true;
        int total = now;
        for(int i=0;i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];

            if(!isRange(ny,nx,map.length, map[0].length)){continue;}
            if(visit[ny][nx]
                    || map[ny][nx]== -1)
            { continue; }
            total += dfs(ny, nx, map[ny][nx], map);
        }
        return total;
    }

    boolean isRange(int y,int x, int my,int mx){
        return 0<=y && y<my && 0<=x && x<mx;
    }
}
