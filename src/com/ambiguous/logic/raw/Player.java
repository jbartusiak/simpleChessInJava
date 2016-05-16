package com.ambiguous.logic.raw;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class Player {
    private Turn m_turn;
    Points m_white, m_black;

    class Points<T extends Integer>{
        T val;

        public Points(){
            val = (T)new Integer(1);
        }

        public void grow(){
            int temp = val.intValue();
            val = (T)new Integer(temp+1);
        }

        public int get(){
            return val.intValue();
        }
    }

    public Player(){
        m_turn = Turn.WHITE;
    }

    public void switchTurn(){
        if (m_turn==Turn.WHITE)m_turn=Turn.BLACK;
        else m_turn=Turn.WHITE;
        System.out.println(m_turn.name()+"'s turn");
    }

    public PieceColor getCurrentTurn(){
        return m_turn==Turn.WHITE?PieceColor.WHITE:PieceColor.BLACK;
    }

    public void whiteIncrement(){m_white.grow();}
    public void blackIncrement(){m_black.grow();}

    public String toString(){
        return "WHITE: "+m_white.get()+" BLACK: "+m_black.get();
    }
}
