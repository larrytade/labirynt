package com.company.Exe.Mitko.DataStructure;

public interface DataStructure<E> {
    void push(E item);

    E pop();

    E top();

    int size();

    boolean isEmpty();
}
