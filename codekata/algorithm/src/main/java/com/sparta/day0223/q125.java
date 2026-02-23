package com.sparta.day0223;

import java.util.*;

public class q125 {
    ArrayList<Integer> list;

    public int solution(int[] cards) {
        int answer = 0;
        list = new ArrayList<>();
        boolean[] visit = new boolean[cards.length];
        for(int card: cards){
            dfs(card, cards, visit, 0);
        }
        list.sort(Comparator.reverseOrder());
        // System.out.println(list.toString());
        return list.get(0)*list.get(1);
    }

    void dfs(int idx, int[] cards, boolean[] visit, int cnt){
        if(visit[cards[idx-1]-1]){
            list.add(cnt);
            return;
        }
        visit[cards[idx-1]-1] = true;
        dfs(cards[idx-1], cards, visit, cnt+1);
    }
}
