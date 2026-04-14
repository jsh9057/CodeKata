package com.sparta.day0414;

import java.util.*;

public class q68 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int answer = 0;
        Stack<List<Integer>> stack = new Stack<>();
        // 1 빵, 2 야채, 3 고기
        for(int i=0;i<ingredient.length;i++){
            if(ingredient[i]==1){
                if(!stack.isEmpty()){
                    List<Integer> list = stack.peek();
                    if(isMake(list)){
                        stack.pop();
                        answer++;
                        continue;
                    }
                }
                stack.push(new ArrayList<>(List.of(1)));
            }else{
                if(stack.isEmpty()){continue;}
                List<Integer> list = stack.pop();
                list.add(ingredient[i]);
                stack.push(list);
            }
        }
        System.out.println(answer);
    }
    static boolean isMake(List<Integer> list){
        if(list.size()!=3){return false;}
        return list.size()==3 && list.get(0)==1 && list.get(1)==2 && list.get(2)==3;
    }
}
