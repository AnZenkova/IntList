package com.company;

import java.util.Arrays;

public class ComparisonOfSorts {

    public IntList intList;

    public ComparisonOfSorts(IntList intList) {
        this.intList = intList;
    }

    public String comparisonOfSort() {

        IntListImpl<Integer> arr = (IntListImpl<Integer>) intList.generateArray();
        IntListImpl<Integer> arr2 = new IntListImpl<>(arr.getArray(), arr.getSize());

        long start = System.currentTimeMillis();
        intList.sort(arr.getArray());
        long a = System.currentTimeMillis() - start;

        long start1 = System.currentTimeMillis();
        Arrays.sort(arr2.getArray());
        long b = System.currentTimeMillis() - start1;

        if (a > b) {
            return "Arrays.sort() " + b + " быстрее чем sort() " + a;
        } else {
            return "sort() " + a + " быстрее чем Arrays.sort() " + b;
        }
    }

    public String comparisonOfBubbleSort() {

        IntListImpl<Integer> arr = (IntListImpl<Integer>) intList.generateArray();
        IntListImpl<Integer> arr2 = new IntListImpl<>(arr.getArray(), arr.getSize());
        long start = System.currentTimeMillis();
        intList.sortBubble(arr.getArray());
        long a = System.currentTimeMillis() - start;

        long start1 = System.currentTimeMillis();
        Arrays.sort(arr2.getArray());
        long b = System.currentTimeMillis() - start1;

        if (a > b) {
            return "Arrays.sort() " + b + " быстрее чем sort() " + a;
        } else {
            return "sortBubble() " + a + " быстрее чем Arrays.sort() " + b;
        }
    }

    public String comparisonOfInsertionSort() {

        IntListImpl<Integer> arr = (IntListImpl<Integer>) intList.generateArray();
        IntListImpl<Integer> arr2 = new IntListImpl<>(arr.getArray(), arr.getSize());
        long start = System.currentTimeMillis();
        intList.sortInsertion(arr.getArray());
        long a = System.currentTimeMillis() - start;

        long start1 = System.currentTimeMillis();
        Arrays.sort(arr2.getArray());
        long b = System.currentTimeMillis() - start1;

        if (a > b) {
            return "Arrays.sort() " + b + " быстрее чем sort() " + a;
        } else {
            return "sortInsertion() " + a + " быстрее чем Arrays.sort() " + b;
        }
    }
}
