package com.sparta.day0219;

public class q42 {
    /*
    [-2, 3, 0, 2, -5] res 2

     */
    public static int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k <number.length; k++) {
                    if(number[i]+number[j]+number[k]==0){answer++;}
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] number1 = {-2, 3, 0, 2, -5};
        System.out.println("solution(number1) = " + solution(number1));
        int[] number2 = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println("solution(number2) = " + solution(number2));
        int[] number3 = {1, 1, -1, 1};
        System.out.println("solution(number3) = " + solution(number3));
    }
}
