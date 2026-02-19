package com.sparta.day0219;

public class q65 {
    public static int solution(String s) {
        int answer = 0;

        if(s.length()==1){return 1;}

        int start = 0;
        int idx = 1;
        char x = s.charAt(0);
        int xCnt = 1;
        int notXCnt = 0;

        // StringBuilder sb = new StringBuilder();
        while(idx < s.length()){
            if(s.charAt(idx)==x){ xCnt++; }
            else { notXCnt++; }

            if(xCnt == notXCnt){
                // sb.append(s.substring(start,idx+1)+" / ");
                start = idx+1;
                idx = start+1;
                xCnt = 1;
                notXCnt = 0;
                answer++;
                if(s.length() <= start){ break; }
                x = s.charAt(start);
            }
            else{ idx++; }
            if(idx>=s.length()){ answer++; break; }
        }
        // System.out.println(sb);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution(\"abracadabra\") = " + solution("abracadabra"));
    }
}
