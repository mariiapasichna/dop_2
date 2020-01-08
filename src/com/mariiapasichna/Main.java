package com.mariiapasichna;

import java.util.Arrays;

public class Main {

    /*2. Заданы строка с выражением состоящая из чисел и знаков плюс/минус разделенным пробелом, например "123 + 7 - 52".
     Вычислить значение выражения.
2.1. Также в выражении могут присутстовать знаки умножить и разделить. Вычислить значение строки с учетом приоритета операторов.*/

    public static void main(String[] args) {
        String s = "10 - 3 / 2";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));

        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == '*' || arr[i].charAt(0) == '/') {
                if (arr[i].charAt(0) == '*') {
                    if (res == 0) {
                        res = Integer.parseInt(arr[i - 1]) * Integer.parseInt(arr[i + 1]);
                    } else {
                        res *= Integer.parseInt(arr[i + 1]);
                    }
                }
                if (arr[i].charAt(0) == '/') {
                    if (res == 0) {
                        res = (double) Integer.parseInt(arr[i - 1]) / Integer.parseInt(arr[i + 1]);
                    } else {
                        res /= Integer.parseInt(arr[i + 1]);
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == '+' || arr[i].charAt(0) == '-') {
                if (arr[i].charAt(0) == '+') {
                    if (res == 0) {
                        res = Integer.parseInt(arr[i - 1]) + Integer.parseInt(arr[i + 1]);
                    } else if (i == 1) {
                        res += Integer.parseInt(arr[i - 1]);
                    } else if (i > 1) {
                        res += Integer.parseInt(arr[i + 1]);
                    }
                }
                if (arr[i].charAt(0) == '-') {
                    if (res == 0) {
                        res = Integer.parseInt(arr[i - 1]) - Integer.parseInt(arr[i + 1]);
                    } else if (i == 1) {
                        res = Integer.parseInt(arr[i - 1]) - res;
                    } else if (i > 1) {
                        res -= Integer.parseInt(arr[i + 1]);
                    }
                }
            }
        }
        System.out.println(res);
    }
}