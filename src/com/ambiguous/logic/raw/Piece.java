package com.ambiguous.logic.raw;

import com.ambiguous.interfaces.Drawable;
import com.ambiguous.interfaces.Moveable;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Kubuś on 2016-03-18.
 */
public abstract class Piece implements Moveable, Drawable {
    private int m_x, m_y;
    protected Type m_type;
    protected PieceColor m_color;
    protected BufferedImage m_identity;

    public Piece(int x, int y, PieceColor c){
        m_x=x;
        m_y=y;
        m_color=c;
        initIdentity();
    }

    protected abstract void initIdentity();

    public int getX(){return m_x;}
    public int getY(){return m_y;}
    public Type getType(){return m_type;}
    public PieceColor getColor() {return m_color;}

    public void setX(int x){m_x=x;}
    public void setY(int y){m_y=y;}

    @Override
    public void drawObject(Graphics2D g) {
        g.drawImage(m_identity,getX(),getY(),null);
    }

    @Override
    public String toString() {
        return m_color+ " " + m_type.name()+" at x:"+m_x+", y:"+m_y;
    }
}
