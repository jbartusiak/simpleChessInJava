package com.ambiguous.logic.Pieces;

import com.ambiguous.exception.UnimplementedException;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.PieceIdentity;
import com.ambiguous.logic.raw.Type;

/**
 * Created by Kubuś on 2016-03-18.
 */
public class Pawn extends Piece{
    public Pawn(int x, int y, PieceColor c){
        super(x,y,c);
        m_type= Type.PAWN;
    }

    protected void initIdentity() {
        if (m_color == PieceColor.WHITE)
            m_identity = PieceIdentity.PAWN_WHITE;
        else m_identity = PieceIdentity.PAWN_BLACK;
    }

    @Override
    public void move(int x, int y) {
        setX(x*100);
        setY(y*100);
    }

    @Override
    public boolean isValidMove(int x, int y) {
        x*=100;y*=100;
        if(m_color==PieceColor.WHITE){
            if ((Math.abs(getY()-y)<=200&&getY()>y)&&x==getX()) return true;
        }
        else{
            if (Math.abs(getY()-y)<=200&&getY()<y&&x==getX()) return true;
        }
        return false;
    }
}
