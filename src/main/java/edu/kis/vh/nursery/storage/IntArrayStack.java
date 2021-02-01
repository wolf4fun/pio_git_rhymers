package edu.kis.vh.nursery.storage;

public class IntArrayStack implements IntStorage{
    //! Correction based on https://gist.github.com/kowallus/af13f7e430fbf1a7c9a293b9e57e66bc

    private static final int EMPTY_RHYMER_INDICATOR = -1;
    private int total = EMPTY_RHYMER_INDICATOR;

    private static final int CAPACITY = 12;
    private final int[] numbers = new int[CAPACITY];

    /**
     * @param in Getter for total variable
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * @param in Adding element to numbers array
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * @return boolean Checking if index of array has a default value (EMPTY_RHYMER_INDICATOR)
     */
    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    /**
     * @return boolean Checking if array of numbers is full
     */
    public boolean isFull() {
        return total == CAPACITY - 1;
    }

    /**
     * @return int On succes returns the last element of array, IS_EMPTY is
     *         returned otherwise
     */
    public int peekaboo() {
        if (callCheck())
            return IS_EMPTY;
        return numbers[total];
    }

    /**
     * @return int On succes returns last element and decrements index of array
     *         numbers, IS_EMPTY is returned otherwise
     */
    public int countOut() {
        if (callCheck())
            return IS_EMPTY;
        return numbers[total--];
    }

    @Override
    public void push(int value) {
        countIn(value);
    }

    @Override
    public boolean isEmpty() {
        return callCheck();
    }

    @Override
    public int top() {
        return peekaboo();
    }

    @Override
    public int pop() {
        return countOut();
    }

}
