package com.design.refactoring.pattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();

        // 악보 초기화 (각 악보가 차지하는 시간으로)
        int bTime = 0;
        int array[][] = new int[N + 1][1];
        for (int i = 1; i <= N; i++) {
            array[i][0] = bTime + scan.nextInt();
            bTime = array[i][0]; // 연속하는 시간 구간을 만들기 위해 (Ex. 0~3초, 3~7초 ..)
        }

        // 질문을 할 시간 초기화
        int q[] = new int[Q];
        for (int i = 0; i < Q; i++) {
            q[i] = scan.nextInt();
        }

        int result[] = new int[Q];
        // TODO : 구간 비교 ...
        for (int i = 0; i < Q; i++) {
            int time = q[i]; // 찾는 시간
            for (int j = 1; j <= N; j++) {
                if (time < array[j][0]) {
                    result[i] = j;
                    break;
                } else if (time == array[j][0]) {
                    result[i] = j + 1;
                    break;
                }
            }
        }

        // 결과보기
        for (int i = 0; i < Q; i++) {
            System.out.println(result[i]);
        }

    }
}
