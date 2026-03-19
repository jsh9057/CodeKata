package com.sparta.day0319;

import java.util.LinkedList;
import java.util.Queue;

public class q100 {
    /*
        x	y	n	result
        10	40	5	2
        10	40	30	1
        2	5	4	-1
     */
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 30;
        int answer = 0;
        boolean[] visit = new boolean[1000001];

        Queue<Integer[]> queue = new LinkedList<>();
        visit[x]=true;
        queue.add(new Integer[]{x, 0});
        while (!queue.isEmpty()) {
            Integer[] q = queue.poll();
            int now = q[0];
            int cnt = q[1];
            if (now == y) {
                System.out.println(cnt);
                return;
            }
            if (y >= now + n) {
                if (!visit[now + n]) {
                    visit[now + n] = true;
                    queue.add(new Integer[]{now + n, cnt + 1});
                }
            }

            if (y >= now * 2) {
                if (!visit[now * 2]) {
                    visit[now * 2] = true;
                    queue.add(new Integer[]{now * 2, cnt + 1});
                }
            }

            if (y >= now * 3) {
                if (!visit[now * 3]) {
                    visit[now * 3] = true;
                    queue.add(new Integer[]{now * 3, cnt + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
