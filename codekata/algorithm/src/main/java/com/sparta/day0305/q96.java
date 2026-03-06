package com.sparta.day0305;

import java.util.*;

public class q96 {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> timeMap = new HashMap<>();
        HashMap<Integer,Boolean> isOut = new HashMap<>();
        HashMap<Integer,Integer> total = new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[] split = records[i].split(" ");

            if(split[2].equals("IN")){
                map.put(Integer.parseInt(split[1]), timeToInt(split[0]));
                isOut.put(Integer.parseInt(split[1]), false);
            }
            else{
                timeMap.put(Integer.parseInt(split[1]),
                        (timeMap.getOrDefault(Integer.parseInt(split[1]),0)+timeToInt(split[0]) - map.get(Integer.parseInt(split[1]))));
                isOut.put(Integer.parseInt(split[1]), true);
            }
        }
        for(Integer k :isOut.keySet()){
            if(!isOut.get(k)){
                timeMap.put(k,
                        (timeMap.getOrDefault(k,0)+timeToInt("23:59") - map.get(k)));
            }
        }

        List<Integer> sort = new ArrayList<>(map.keySet());
        Collections.sort(sort);
        int basicTime = fees[0];
        int basicFee = fees[1];
        int plusTime = fees[2];
        int plusFee = fees[3];
        for(int i=0;i<map.size();i++){
            Integer nowTime = timeMap.getOrDefault(sort.get(i),0);
            if(basicTime>=nowTime){
                total.put(sort.get(i),basicFee);
            }else{
                total.put(sort.get(i),(int) (basicFee + Math.ceil((double) (nowTime - basicTime) / plusTime) *plusFee)) ;
            }
        }
        int[] ret = new int[sort.size()];
        for(int i=0;i<map.size();i++){
            ret[i]=total.get(sort.get(i));
        }
        return ret;
    }

    int timeToInt(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
}
