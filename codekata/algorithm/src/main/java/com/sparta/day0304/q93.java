package com.sparta.day0304;

public class q93 {
    static int max;
    public int solution(int k, int[][] dungeons) {
        max=0;
        dfs(k,0,dungeons,new boolean[dungeons.length]);
        return max;
    }
    void dfs(int k, int count,int[][] dungeons, boolean[] visit){
        max=Math.max(max,count);

        for(int i=0; i<dungeons.length; i++){
            if(visit[i]){ continue; }
            if(k>=dungeons[i][0]){
                visit[i]=true;
                dfs(k-dungeons[i][1], count+1, dungeons, visit);
                visit[i]=false;
            }
        }
    }
}
