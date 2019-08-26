package com.snippets.ds;

import java.util.Arrays;

public class BinaryHeap<Key extends Comparable<Key>> {


    private static final float EXTEND_FACTOR = 0.8f;
    private static final float REDUCE_FACTOR = 0.3f;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private Key[] heap;
    private int N = 0;
    private boolean reverse = true;


    public BinaryHeap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        heap = (Key[]) new Comparable[capacity+1];
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key v) {

        if(N >= (int) (heap.length * EXTEND_FACTOR)) {
            Arrays.copyOf(heap, heap.length *2);
        }
        heap[++N] = v;
        swim(N);
    }

    public Key poll() {

        if(isEmpty()) {
            return null;
        }
        if (N <= (int) (heap.length * REDUCE_FACTOR)) {
            Arrays.copyOf(heap, heap.length/2);
        }
        Key max = heap[1];
        swap(1, N--);
        sink(1);
        return max;
    }


    private void sink(int k) {

        int j = 2*k;
        while (2*k <= N) {
            if( j + 1 <=N && priorTo(heap[j+1], heap[j])) {
                j++;
            }
            if(priorTo(heap[j], heap[k])) {
                swap(j, k);
                k = 2*k;
            }else {
                break;
            }
        }
    }

    private void swim(int k) {

        while (k > 1) {
            if (priorTo(heap[k], heap[k/2])) {
                swap(k, k/2);
                k = k/2;
            }else {
                break;
            }
        }
    }

    private void swap(int i, int j) {

        Key tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private boolean priorTo(Key i, Key j) {
        if (reverse) {
            return i.compareTo(j) > 0;
        }
        return i.compareTo(j) < 0;
    }

}

class TestHeap {
    public static void main(String[] args) {

        BinaryHeap heap = new BinaryHeap();
        //System.out.println(heap.isEmpty());
        heap.insert(6);
        heap.insert(2);
        heap.insert(5);
        heap.insert(10);


        //System.out.println(heap.isEmpty());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}
