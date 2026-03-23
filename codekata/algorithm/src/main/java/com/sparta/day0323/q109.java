package com.sparta.day0323;

public class q109 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;

        int now = 0;
        int start = 0;
        int len = 1000001;
        int[] result = new int[2];
        for(int end=0;end<sequence.length;end++){
            now +=  sequence[end];
            while (start <= end){
                if(now < k){
                    break;
                }
                else if(now > k){
                    now -= sequence[start];
                    start++;
                }
                else if (now == k){
                    if(len > (end - start)){
                        len = end - start;
                        result[0]=start;
                        result[1]=end;
                    }
                    break;
                }
            }
        }
        System.out.println(result[0]+", "+result[1]);
    }
}
