package com.design.refactoring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); // 사람 수
        int n = scan.nextInt(); // 가로줄의 수

        // 참가자들의 기준 순서 (A,B,C,D,E...)
        char[] standard = new char[k];
        for (int i = 0; i < k; i++) {
            standard[i] = (char) (65 + i);
        }
        scan.nextLine();

        // 참가자들의 최종 순서
        char[] order = scan.nextLine().toCharArray();

        // 사다리의 모양
        char[][] ladder = new char[n][k];
        for (int i = 0; i < n; i++) {
            ladder[i] = scan.nextLine().toCharArray();
        }

        // 최종 결과
        char[] result = new char[k];

        // 1. '-' 만나면 두 문자의 순서를 서로 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k-1; j++) { // 사다리 세로줄 수는 사람 수보다 1 작으므로 k-1이다.
                if (ladder[i][j] == '-') {
                    char temp = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp;
                    // 2. '?' 만나면 문자 순서를 답과 비교, 동일할 경우 '*' 이며 서로 교차해야하면 '-' 일 것이다. (그 외는 불가능한 경우)
                } else if (ladder[i][j] == '?') {
                    System.out.println(j + ": " + standard[j] + ", " + order[j]);
                    if (standard[j] == order[j]) {
                        result[j] = '*';
                    } else {
                        result[j] = '-';
                    }
                }
            }
        }

        System.out.println(String.valueOf(result));
    }
}

// https://www.acmicpc.net/problem/2469
// https://algosu.tistory.com/5