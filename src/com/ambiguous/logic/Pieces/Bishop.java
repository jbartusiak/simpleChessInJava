package com.ambiguous.logic.Pieces;

import com.ambiguous.exception.UnimplementedException;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.PieceIdentity;
import com.ambiguous.logic.raw.Type;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class Bishop extends Piece {
    public Bishop(int x, int y, PieceColor c){
        super(x,y,c);
        m_type= Type.BISHOP;
    }

    @Override
    protected void initIdentity() {
        if (m_color == PieceColor.WHITE)
            m_identity = PieceIdentity.BISHOP_WHITE;
        else m_identity = PieceIdentity.BISHOP_BLACK;
    }

    @Override
    public boolean isValidMove(int x, int y) {
        x*=100;
        y*=100;
        if(Math.abs(x-getX())==Math.abs(y-getY())) return true;
        else return false;
    }

    @Override
    public void move(int x, int y) {
        x*=100;
        y*=100;

        setX(x);
        setY(y);
    }
}
