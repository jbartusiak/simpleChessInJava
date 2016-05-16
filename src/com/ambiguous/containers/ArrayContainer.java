package com.ambiguous.containers;

/**
 * Prosty kontener tablicowy, demonstrujący wykorzystanie mechanizmów generycznych
 */
public class ArrayContainer<T1>{
    /**
     * @param INIT_SIZE - domyślny rozmiar tablicy
     * @param m_array - tablica obiektów
     * @param m_size - obecny rozmiar tablicy (tj. ilość zawatych w niej parametrów)
     */
    private static final int INIT_SIZE=50;
    private T1[] m_array;
    private int m_size;

    public ArrayContainer(){
        m_array = (T1[])new Object[INIT_SIZE];
        m_size = 0;
    }

    /**
     * pobiera elemnt z tablicy
     * @throws ArrayIndexOutOfBoundsException w przypadku wskazania parametru poza zakresem
     * @param index parametr określający, który obiekt pobrać
     * @return wybrany obiekt
     */
    public T1 get(int index){
        if(index>=m_size) throw new ArrayIndexOutOfBoundsException();
        return m_array[index];
    }

    public T1 get(){
        return m_array[0];
    }

    /**
     * dodaje do tablicy obiekt
     * @param item
     */
    public void add(T1 item){
        m_array[m_size]=item;
        m_size++;
    }

    /**
     * Usuwa element z tablicy
     * @param index element do usunięcia
     * @throws ArrayIndexOutOfBoundsException w przypadku gdy zadany indeks nie jest w tablicy
     */
    public void remove(int index){
        if(index>=m_size) throw new ArrayIndexOutOfBoundsException();
        ArrayContainer<T1> temp = new ArrayContainer<>();
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

    private T1[] getArray(){
        return m_array;
    }
}
