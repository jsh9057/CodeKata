package com.sparta.day0317;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q97 {
    static char[] word = {'A', 'E', 'I', 'O', 'U'};
    static List<String> dictionary;

    public int solution(String word) {
        List<String> list = new ArrayList<>();
        dictionary = new ArrayList<>();
        setWords("",0,5);
        Collections.sort(list);

        for (int i = 0; i < dictionary.size(); i++) {
            if(word.equals(dictionary.get(i))){
                return i+1;
            }
        }
        return -1;
    }

    void setWords(String now, int nowLen, int maxLen){
        if(nowLen >= maxLen){ return; }

        for(int i=0;i<word.length;i++){
            String tmp = now + word[i];
            if(!tmp.isBlank()){
                dictionary.add(tmp);
                setWords(tmp,nowLen+1,maxLen);
            }
        }
    }
}
