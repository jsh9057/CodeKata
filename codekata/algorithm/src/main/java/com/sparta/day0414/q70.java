package com.sparta.day0414;

public class q70 {
    public static void main(String[] args) {

        solution(new String[] {".#...", "..#..", "...#."});
        System.out.println("[0, 1, 3, 4]");
        solution(new String[] {"..........", ".....#....", "......##..", "...##.....", "....#....."});
        System.out.println("[1, 3, 5, 8]");
        solution(new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        System.out.println("[0, 0, 7, 9]");
        solution(new String[] {"..", "#."});
        System.out.println("[1, 0, 2, 1]");

    }
    public static void solution(String[] wallpaper) {
        int minY=52;
        int minX=52;
        int maxY=0;
        int maxX=0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c=='.'){ continue; }
                minY = Math.min(i,minY);
                minX = Math.min(j,minX);
                maxY = Math.max(i,maxY);
                maxX = Math.max(j,maxX);
            }
        }
        System.out.printf("(%d, %d)  (%d, %d)%n", minY, minX, maxY+1, maxX+1);
    }
}
