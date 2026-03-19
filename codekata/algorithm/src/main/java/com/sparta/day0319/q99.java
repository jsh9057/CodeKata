package com.sparta.day0319;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q99 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t: topping){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<topping.length;i++){
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i])-1);
            int quantity = map.getOrDefault(topping[i],0);
            if(quantity == 0){map.remove(topping[i]);}
            if(set.size() == map.size()){ answer++; }
        }
        System.out.println(answer);
    }
}
