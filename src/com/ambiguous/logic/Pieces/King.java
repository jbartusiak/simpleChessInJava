package com.ambiguous.logic.Pieces;

import com.ambiguous.exception.UnimplementedException;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.PieceIdentity;
import com.ambiguous.logic.raw.Type;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class King extends Piece {
    public King(int x, int y, PieceColor c){
        super(x,y,c);
        m_type= Type.KING;
    }

    @Override
    protected void initIdentity() {
        if (m_color == PieceColor.WHITE)
            m_identity = PieceIdentity.KING_WHITE;
        else m_identity = PieceIdentity.KING_BLACK;
    }

    @Override
    public boolean isValidMove(int x, int y) {
        throw new UnimplementedException();
    }

    @Override
    public void move(int x, int y) {
        throw new UnimplementedException();
    }
}
