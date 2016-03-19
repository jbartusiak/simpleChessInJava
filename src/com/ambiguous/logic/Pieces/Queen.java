package com.ambiguous.logic.Pieces;

import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.PieceIdentity;
import com.ambiguous.logic.raw.Type;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class Queen extends Piece{
    public Queen(int x, int y, PieceColor c){
        super(x,y,c);
        m_type= Type.QUEEN;
    }

    @Override
    protected void initIdentity() {
        if (m_color == PieceColor.WHITE)
            m_identity = PieceIdentity.QUEEN_WHITE;
        else m_identity = PieceIdentity.QUEEN_BLACK;
    }

    @Override
    public boolean isValidMove(int x, int y) {
        x*=100;
        y*=100;
        int dX = Math.abs(x-getX());
        int dY=Math.abs(y-getY());

        if(dX==dY) return true;
        else if (x==getX()||y==getY()) return true;
        else return false;
    }
}
