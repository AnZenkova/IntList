package com.company;

public class Main {

    public static void main(String[] args) {

        IntList intList = new IntListImpl();

        int[] list = {5, 9, 8, 10, 4, 50, 36};

        System.out.println(intList.contains(100_001));


        long start = System.currentTimeMillis();
        intList.contains(100_001);
        System.out.println(System.currentTimeMillis() - start);

    }
}
