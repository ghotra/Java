package com.baljinder;

/*
    Project Euler #2: Even Fibonacci Numbers
 */

public class Main {
    public static void main(String[] args) {
        int firstNum = 0,secondNum=1;
        int thirdNum = 0;
        int sumOfEvenNum = 0;
        sumOfEvenNum += firstNum;
        while(thirdNum<4000000){
            thirdNum = firstNum +  secondNum;
            firstNum = secondNum;
            secondNum = thirdNum;
            if(thirdNum%2 == 0){
                //Cover this part to check for INTEGER.MAX: https://stackoverflow.com/questions/6631142/project-euler-problem-2-sum-of-even-fibonacci-numbers
                if(sumOfEvenNum >= Integer.MAX_VALUE){
                    break;
                }else {
                    sumOfEvenNum += thirdNum;
                }
            }
        }
        System.out.println(sumOfEvenNum);
    }
}
