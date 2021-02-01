package edu.kis.vh.nursery;

import edu.kis.vh.nursery.storage.IntArrayStack;
import edu.kis.vh.nursery.storage.IntLinkedList;
import edu.kis.vh.nursery.storage.IntStorage;
public class DefaultCountingOutRhymer {
    private final IntStorage intStore;

    public DefaultCountingOutRhymer(IntStorage intStorage) {
        this.intStore = intStorage;
    }

    public DefaultCountingOutRhymer() {
        //! For Demo IntArrayStack was chosen over IntLinkedList however if size of container is not known, using IntLinkedList() is preferred
        intStore = new IntArrayStack();
        // intStore = new IntLinkedList();
    }

    public int getTotal() {
        return intStore.getTotal();
    }

    public void countIn(int in) {
        intStore.push(in);
    }

    public boolean callCheck() {
        return intStore.isEmpty();
    }

    public boolean isFull() {
        return intStore.isFull();
    }

    public int peekaboo() {
        return intStore.top();
    }

    public int countOut() {
        return intStore.pop();
    }

}
