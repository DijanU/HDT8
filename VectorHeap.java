/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT8, heap y priorityQueue
 * 08-04-2024
 * @vectorHeap
 */

import java.util.PriorityQueue;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    public boolean add(E e) {
        data.add(e);
        percolateUp(data.size() - 1);
        return true;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (data.get(index).compareTo(data.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public boolean offer(E e) {
        return add(e);
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = data.firstElement();
        data.set(0, data.lastElement());
        data.remove(data.size() - 1);
        if (!isEmpty()) {
            heapify(0);
        }
        return removedElement;
    }

    private void heapify(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < data.size() && data.get(leftChild).compareTo(data.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < data.size() && data.get(rightChild).compareTo(data.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
