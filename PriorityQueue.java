/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT8, heap y priorityQueue
 * 08-04-2024
 * @priorityQueue
 */

import java.util.Arrays;

public class PriorityQueue<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public PriorityQueue() {
        array = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == array.length - 1) {
            ensureCapacity(array.length * 2);
        }
        size++;
        int index = size;
        while (index > 1 && element.compareTo(array[index / 2]) < 0) {
            array[index] = array[index / 2];
            index = index / 2;
        }
        array[index] = element;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[1];
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = array[1];
        array[1] = array[size];
        size--;
        heapify(1);
        return removedElement;
    }

    private void heapify(int index) {
        E temp = array[index];
        int child;
        while (index * 2 <= size) {
            child = index * 2;
            if (child != size && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(temp) < 0) {
                array[index] = array[child];
            } else {
                break;
            }
            index = child;
        }
        array[index] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }
        array = Arrays.copyOf(array, capacity);
    }
}

