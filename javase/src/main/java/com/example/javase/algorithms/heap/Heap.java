package com.example.javase.algorithms.heap;

public class Heap<T> {

    private T[] heap;


    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private void maxHeapify(int[] heap, int index) {
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        int largestIndex = index;
        if (leftChildIndex < heap.length && heap[leftChildIndex] > heap[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.length && heap[rightChildIndex] > heap[largestIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != index) {
            int tmp = heap[index];
            heap[index] = heap[largestIndex];
            heap[largestIndex] = tmp;
            maxHeapify(heap, largestIndex);
        }
    }

    public void buildMaxHeapify(int[] heap) {

    }
}
