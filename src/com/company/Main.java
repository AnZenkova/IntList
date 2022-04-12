package com.company;

public class Main {

    public static void main(String[] args) {

        IntList intList = new IntListImpl();

        intList.add(3);
        intList.add(10);

        Integer[] list = intList.generateArray();


        System.out.println(intList.comparisonOfSort());

    }
}
