package com.ambiguous.interfaces;

import java.awt.*;

/**
 * Created by Kubuś on 2016-03-19.
 */
public interface Drawable {
    /**
     * Rysuje obiekt na kontekscie graficznym
     * @param g kontekt graficzny
     */
    public void drawObject(Graphics2D g);
}
