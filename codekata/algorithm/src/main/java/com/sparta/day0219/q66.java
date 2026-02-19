package com.sparta.day0219;

import java.util.Arrays;

public class q66 {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] keyCount = new int[26];
        int[] answer = new int[targets.length];

        for(int i=0; i<26;i++){ keyCount[i]=101; }

        for(String key :keymap){
            for(int i=0; i<key.length(); i++){
                char k = key.charAt(i);
                keyCount[k-'A'] = keyCount[k-'A'] > i+1 ? i+1 : keyCount[k-'A'];
                // System.out.println(k +": "+ keyCount[k-'A']);
            }
        }

        int idx = 0;
        for(String target : targets){
            int cnt = 0;
            for(int i=0; i<target.length(); i++){
                char c = target.charAt(i);
                if(keyCount[c-'A']==101){ answer[idx]=-1; break; }
                cnt += keyCount[c-'A'];
            }
            if(answer[idx]!=-1){ answer[idx] = cnt; }
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        // result = [9, 4]
        System.out.println("solution(keymap, targets) = " + Arrays.toString(solution(keymap, targets)));

        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        // result = [-1]
        System.out.println("solution(keymap, targets) = " + Arrays.toString(solution(keymap2, targets2)));

        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA","BGZ"};
        // result = [4, 6]
        System.out.println("solution(keymap, targets) = " + Arrays.toString(solution(keymap3, targets3)));
    }
}
