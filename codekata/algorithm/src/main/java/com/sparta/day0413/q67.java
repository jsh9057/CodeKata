package com.sparta.day0413;

import java.util.HashSet;
import java.util.Set;

public class q67 {
    public String solution(String s, String skip, int index) {
        String result = "";
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()){
            skipSet.add(c);
        }
        for(int i= 0; i<s.length(); i++){
            char now = s.charAt(i);
            for (int j = 0; j < index; j++) {
                now = (char)(now+1);
                if(skipSet.contains(now)){ j--; }
                if(now > 'z'){
                    now -= 26;
                    if(skipSet.contains(now)){ j--; }
                }
            }
            result = result + now;
        }
        return result;
    }
}
