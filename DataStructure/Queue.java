package com.company.Exe.Mitko.DataStructure;

public class Queue<E> implements DataStructure<E> {
    protected final LinkedList<E> items;

    public Queue() {
        this.items = new LinkedList<E>();
    }

    public int size() {
        return items.sizeOf();
    }



    @Override
    public void push(E item) {
        items.add(item);
    }

    public E pop() {
        if (!isEmpty()) {
            E item = items.get(0);
            items.removeOnPosition(0);

            return item;
        }

        throw new IndexOutOfBoundsException("The queue is empty");
    }

    public E top() {
        if (!isEmpty()) {
            return items.get(0);
        }

        throw new IndexOutOfBoundsException("The queue is empty");
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

}
