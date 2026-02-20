package com.sparta.day0220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q123 {
    static ArrayList<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();

        hanoi(n, 1,3,2);

        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        Queue<int[]> q = new LinkedList<>();
        return answer;
    }

    void hanoi(int n, int from, int to, int tmp){
        if(n==1){
            list.add(new int[]{from, to});
            return;
        }

        hanoi(n-1, from, tmp, to);

        list.add(new int[]{from, to});

        hanoi(n-1, tmp, to, from);
    }
}
