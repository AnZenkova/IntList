package com.company;

public interface IntList {

    Integer add(Integer item);
    Integer add(int index, Integer item);
    Integer set(int index, Integer item);
    Integer removeIt(Integer item);
    Integer remove(int index);
    boolean contains(Integer item);
    Integer indexOf(Integer item);
    Integer lastIndexOf(Integer item);
    Integer get(int index);
    boolean equals(IntList otherList);
    int size();
    boolean isEmpty();
    void clear();
    Integer[] toArray();
    IntList generateArray();
    void sort(Integer[] arr);

    void sortBubble(Integer[] arr);

    void sortInsertion(Integer[] arr);

    void mergeSort(Integer[] arr);
}
