package com.ambiguous.interfaces;

/**
 * Created by Kubuś on 2016-03-19.
 */
public interface Moveable {
    /**
     * Metoda sprawdza, czy dany ruch jest prawidlowy
     * @param x lokalizacja x
     * @param y lokalizacja y
     * @return true gdy ruch prawidlowy, false w przeciwnym wypadku
     */
    public boolean isValidMove(int x, int y);

    /**
     * Porusza obiekt do punktu zadanego parametrami
     * @param x
     * @param y
     */
    public void move(int x, int y);
}
