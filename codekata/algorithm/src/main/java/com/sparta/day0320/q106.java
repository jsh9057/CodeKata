package com.sparta.day0320;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q106 {
    public static void main(String[] args) {
//        int[] order = {4, 3, 1, 2, 5};
        int[] order = {5, 4, 3, 2, 1};
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<order.length;i++){

            if(list.size()+1 == order[i]){
                list.add(order[i]);
            }else {
                stack.add(order[i]);
            }
        }
        while(!stack.isEmpty()){
            int now = stack.peek();
            if(list.size()+1 == now){
                list.add(now);
                stack.pop();
            }
            else {
                System.out.println(list.size());
                return;
            }
        }
        System.out.println(list.size());
    }
}
