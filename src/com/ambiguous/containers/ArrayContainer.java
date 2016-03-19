package com.ambiguous.containers;

import java.util.ArrayList;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class ArrayContainer<T>{
    private static final int INIT_SIZE=50;
    private T[] m_array;
    private int m_size;

    public ArrayContainer(){
        m_array = (T[])new Object[INIT_SIZE];
        m_size = 0;
    }

    public T get(int index){
        if(index>=m_size) throw new ArrayIndexOutOfBoundsException();
        return m_array[index];
    }

    public int getSize(){
        return m_size;
    }

    public void add(T item){
        m_array[m_size]=item;
        m_size++;
    }

    public void remove(int index){
        if(index>=m_size) throw new ArrayIndexOutOfBoundsException();
        ArrayContainer<T> temp = new ArrayContainer<>();
        for (int i=0; i<m_size; i++){
            if(i!=index) temp.add(m_array[i]);
        }
        m_size--;
        m_array=temp.getArray();
        System.out.println("Removed item no"+index);
    }

    public int size(){
        return m_size;
    }

    private T[] getArray(){
        return m_array;
    }
}
