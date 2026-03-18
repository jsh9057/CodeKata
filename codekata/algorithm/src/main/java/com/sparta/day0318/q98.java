package com.sparta.day0318;

import java.util.*;

public class q98 {
    public int[] solution(int[] numbers) {
        int[] ret = new int[numbers.length];
        int idx = numbers.length-1;
        ret[idx--] = -1;

        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length-2; i>=0; i--){
            if(numbers[i+1]>numbers[i]){
                stack.push(numbers[i+1]);
                ret[idx--]=numbers[i+1];
                continue;
            }
            while (!stack.isEmpty()) {
                int now = stack.peek();
                if(now > numbers[i]){
                    ret[idx--] = now;
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                ret[idx--]=-1;
            }
        }
        return ret;
    }
}
