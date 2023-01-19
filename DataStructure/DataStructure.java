package com.company.Exe.MitkoVerson2.DataStructure;

public interface DataStructure<E> {
    void push(E item);

    E pop();

    E top();

    int size();

    boolean isEmpty();
}
