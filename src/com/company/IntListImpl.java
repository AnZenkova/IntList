package com.company;

import java.util.Arrays;

public class IntListImpl<start> implements IntList{

    private final int[] array = generateRandomArray();
    private final int size = size();


    private static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    @Override
    public int add(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = item;
                return array[i];
            }
        }
        return Integer.parseInt("Массив уже заполнен элементами");
    }

    @Override
    public int add(int index, int item) {
        if (index >= array.length) {
            throw new IndexLargerSizeOfArrayException("Значение индекса " + index + " больше чем размер массива!");
        } else {
            array[index] = item;
        }
        return item;
    }

    @Override
    public int set(int index, int item) {
        if (index >= array.length) {
            throw new IndexLargerSizeOfArrayException("Значение индекса " + index + " больше чем размер массива!");
        } else if (array[index] == 0) {
            throw new NullElementInTheArray("В ячейке " + index + " отсутсвует оъект, примените метод add()");
        } else {
            array[index] = item;
        }
        return item;
    }

    @Override
    public int removeIt(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                array[i] = 0;
                return Integer.parseInt(item + ": Удален");
            }
        }
        throw new NullElementInTheArray(item + ": данный объект не найден");
    }

    @Override
    public int remove(int index) {
        int number;
        if (array[index] == 0) {
            throw new NullElementInTheArray("В ячейке под индесом " + index + " null");
        } else {
            number = array[index];
            array[index] = 0;
        }
        return Integer.parseInt("Элемент: " + number + " под индексом " + index + " удален");
    }

    @Override
    public boolean contains(int item) {
        sort(array);
        int element = searchBin(array, item);
        if (element != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = array.length; i >= 0; i--) {
            if (array[i - 1] == item) {
                return i - 1;
            }
        }
        return -1;
    }

    @Override
    public int get(int index){
        if (array[index] == 0) {
            throw new NullElementInTheArray("В ячейке под индексом " + index + " объект отсутствует");
        } else {
            return array[index];
        }
    }

    @Override
    public boolean equals(IntList otherList) {
        boolean result = true;
        if (otherList == null) {
            throw new NullElementInTheArray("Один из объектов отсутствует!");
        } else if (array.length != otherList.size()) {
            return false;
        } else {
            int eL = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == otherList.get(i)) {
                    eL++;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        int size = 0;
        for (int s : array) {
            if (s != 0) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    @Override
    public int[] toArray() {
        int[] array = new int[10];
        return array;
    }

    private void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxEl = Integer.MIN_VALUE;
            int index = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > maxEl) {
                    maxEl = arr[j];
                    index = j;
                }
            }
            int a = arr[i];
            arr[i] = maxEl;
            arr[index] = a;
        }
    }

    private int searchBin(int[] array, int element) {
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == array[mid]) {
                return array[mid];
            }
            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return Integer.parseInt("Данный элемент, не найден");
    }
}
