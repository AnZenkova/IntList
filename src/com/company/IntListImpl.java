package com.company;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl<E> implements IntList{

    private Integer[] array = new Integer[10];
    private int size = size();

    public Integer[] generateArray() { // создаю публичный т.к. хочу сделать проверку в мейне.
        Integer[] arr = generateRandomArray();
        return arr;
    }

    private static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    @Override
    public Integer add(Integer item) {
        if (size == array.length) {
            return Integer.parseInt("Массив уже заполнен элементами");
        }
        array[size] = item;
        size++;
        return array[size];
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= array.length) {
            throw new IndexLargerSizeOfArrayException("Значение индекса " + index + " больше чем размер массива!");
        } else {
            array[index] = item;
            size++;
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
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
    public Integer removeIt(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                array[i] = 0;
                size--;
                return Integer.parseInt(item + ": Удален");
            }
        }
        throw new NullElementInTheArray(item + ": данный объект не найден");
    }

    @Override
    public Integer remove(int index) {
        int number;
        if (array[index] == 0) {
            throw new NullElementInTheArray("В ячейке под индесом " + index + " null");
        } else {
            number = array[index];
            array[index] = 0;
            size--;
        }
        return Integer.parseInt("Элемент: " + number + " под индексом " + index + " удален");
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arr = array;
        sort(arr);
        Integer element = searchBin(array, item);
        if (element != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = array.length; i >= 0; i--) {
            if (array[i - 1] == item) {
                return i - 1;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index){
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
            if (eL == size) {
                return result;
            }
        }
        return result;
    }

    @Override
    public int size() {
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
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[10];
        return array;
    }

    private void sort(Integer[] arr) {
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

    private Integer searchBin(Integer[] array, int element) {
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

    public String comparisonOfSort() {

        Integer[] arr = generateRandomArray();
        Integer[] arr2 = arr;
        long start = System.currentTimeMillis();
        sort(arr);
        long a = System.currentTimeMillis() - start;

        long start1 = System.currentTimeMillis();
        Arrays.sort(arr2);
        long b = System.currentTimeMillis() - start1;

        if (a > b) {
            return "Arrays.sort() " + b + " быстрее чем sort() " + a;
        } else {
            return "sort() " + a + " быстрее чем Arrays.sort() " + b;
        }
    }
}
