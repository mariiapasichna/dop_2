package com.mariiapasichna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /*2. Заданы строка с выражением состоящая из чисел и знаков плюс/минус разделенным пробелом, например "123 + 7 - 52".
     Вычислить значение выражения.
2.1. Также в выражении могут присутстовать знаки умножить и разделить. Вычислить значение строки с учетом приоритета операторов.*/

    public static void main(String[] args) {
        String s = "3 / 3 - 2 / 2";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        List<Double> results = new ArrayList<>();

        priorityOperations(arr, results);
        nonPriorityOperations(arr, results);
        result(results);
    }

    private static void result(List<Double> results) {
        double res1 = 0;
        for (int i = 0; i < results.size(); i++) {
            res1 += results.get(i);
        }
        System.out.println(results);
        System.out.println(res1);
    }

    private static void nonPriorityOperations(String[] arr, List<Double> results) {
        double res;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == '+') {
                if (i == 1 && arr[i].charAt(0) == '+') {
                    res = Integer.parseInt(arr[i - 1]);
                    results.add(res);
                } else if ((i + 2) == arr.length || arr[i + 2].charAt(0) == '+' || arr[i + 2].charAt(0) == '-') {
                    res = Integer.parseInt(arr[i + 1]);
                    results.add(res);
                }
            } else if (arr[i].charAt(0) == '-' && ((i + 2) == arr.length || arr[i + 2].charAt(0) == '+' || arr[i + 2].charAt(0) == '-')) {
                res = -Integer.parseInt(arr[i + 1]);
                results.add(res);
            } else if (i == 1 && arr[i].charAt(0) == '-') {
                res = Integer.parseInt(arr[i - 1]);
                results.add(res);
            }
        }
    }

    private static void priorityOperations(String[] arr, List<Double> results) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == '*' || arr[i].charAt(0) == '/') {
                if (arr[i].charAt(0) == '*') {
                    if (i == 1 || arr[i - 2].charAt(0) == '+' || arr[i - 2].charAt(0) == '-') {
                        if (i == 1) {
                            res = Integer.parseInt(arr[i - 1]) * Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        } else if (arr[i - 2].charAt(0) == '+') {
                            res = Integer.parseInt(arr[i - 1]) * Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        } else if (arr[i - 2].charAt(0) == '-') {
                            res = -Integer.parseInt(arr[i - 1]) * Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        }

                    } else {
                        results.remove(res);
                        res *= Integer.parseInt(arr[i + 1]);
                        results.add(res);
                    }
                }
                if (arr[i].charAt(0) == '/') {
                    if (i == 1 || arr[i - 2].charAt(0) == '+' || arr[i - 2].charAt(0) == '-') {
                        if (i == 1) {
                            res = (double) Integer.parseInt(arr[i - 1]) / Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        } else if (arr[i - 2].charAt(0) == '+') {
                            res = (double) Integer.parseInt(arr[i - 1]) / Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        } else if (arr[i - 2].charAt(0) == '-') {
                            res = -(double) Integer.parseInt(arr[i - 1]) / Integer.parseInt(arr[i + 1]);
                            results.add(res);
                        }

                    } else {
                        results.remove(res);
                        res /= Integer.parseInt(arr[i + 1]);
                        results.add(res);
                    }
                }
            }
        }
    }
}