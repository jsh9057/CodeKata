package com.sparta.day0223;

import java.util.*;

public class q126 {
    ArrayList<Integer> list;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        list = new ArrayList<>();
        dfs(picks,minerals,0,0);
        Collections.sort(list);
        // System.out.println(list.toString());
        return list.get(0);
    }
    void dfs(int[] picks, String[] minerals, int score, int idx){
        if(idx == minerals.length){
            list.add(score);
            return;
        }

        int pickCnt=0;
        for(int i=0;i<3;i++){
            pickCnt+=picks[i];
        }
        if(pickCnt == 0){
            list.add(score);
            return;
        }

        for(int i=0; i<3; i++){
            int total=0;
            int tmpIdx=0;
            if(picks[i]<=0){ continue; }
            picks[i]-=1;
            for(int j=idx; j<idx+5 && j<minerals.length; j++){
                tmpIdx++;
                total+=getScore(i, minerals[j]);
                // System.out.println(i+"곡괭이로 "+minerals[j]+" 캠 / score:"+(total+ score));
            }
            dfs(picks, minerals, score+total, idx+tmpIdx);
            picks[i]+=1;
        }
    }
    //     diamond, iron, stone
    int getScore(int idx, String mineral){
        if(idx==2){
            if(mineral.equals("diamond")){ return 25; }
            else if(mineral.equals("iron")){ return 5; }
        }
        if(idx==1){
            if(mineral.equals("diamond")){ return 5;}
        }
        return 1;
    }
}
