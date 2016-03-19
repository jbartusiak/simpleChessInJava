package com.ambiguous.logic.Pieces;

import com.ambiguous.exception.UnimplementedException;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.PieceIdentity;
import com.ambiguous.logic.raw.Type;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class Knight extends Piece {
    public Knight(int x, int y, PieceColor c){
        super(x,y,c);
        m_type= Type.KNIGHT;
    }

    @Override
    protected void initIdentity() {
        if (m_color == PieceColor.WHITE)
            m_identity = PieceIdentity.KNIGHT_WHITE;
        else m_identity = PieceIdentity.KNIGHT_BLACK;
    }

    @Override
    public boolean isValidMove(int x, int y) {
        x*=100;
        y*=100;
        double dX = Math.abs(x-getX());
        double dY = Math.abs(y-getY());

        if(dX==100&&dY==200) return true;
        else if (dX==200&&dY==100) return true;
        else return false;
    }
}
