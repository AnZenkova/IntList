package com.company;

import java.util.Arrays;

public class IntListImpl<E> implements IntList{

    private Integer[] array = new Integer[10];

    private int size = 0;
    public IntListImpl(Integer[] array, int size) {
        this.array = array;
        this.size = size;
    }

    public Integer[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public IntListImpl<Integer> generateArray() {
        return generateRandomArray();
    }

    private static IntListImpl<Integer> generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return new IntListImpl<Integer>(arr,arr.length);
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
        if (index >= size) {
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
        } else if (array[index] == null) {
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
                array[i] = null;
                size--;
                return Integer.parseInt(item + ": Удален");
            }
        }
        throw new NullElementInTheArray(item + ": данный объект не найден");
    }

    @Override
    public Integer remove(int index) {
        int number;
        if (array[index] == null) {
            throw new NullElementInTheArray("В ячейке под индесом " + index + " null");
        } else {
            number = array[index];
            array[index] = null;
            size--;
        }
        return Integer.parseInt("Элемент: " + number + " под индексом " + index + " удален");
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arr = array;
        sort(arr);
        Integer element = searchBin(array, item);
        if (element != null) {
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
            for (int i = 0; i < array.length; i++) {
                if (array[i] != otherList.get(i)) {
                    return false;
                }
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
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public void sort(Integer[] arr) {
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
        throw new NullElementInTheArray("Данный элемент в массиве не найден");
    }

    public void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                }
            }
        }
    }

    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            Integer j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
