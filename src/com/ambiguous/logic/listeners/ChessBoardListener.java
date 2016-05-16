package com.ambiguous.logic.listeners;

import com.ambiguous.GUI.Checkboard;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.raw.Player;
import com.ambiguous.logic.raw.Turn;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Kubuś on 2016-03-19.
 */
public class ChessBoardListener implements MouseListener {
    private final Checkboard board;
    private Piece currentPiece;
    private Player player;
    private int initX,initY;

    public ChessBoardListener(Checkboard c){
        super();
        board=c;
        currentPiece=null;
        player = new Player();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(currentPiece==null) {
            currentPiece=lookUpSpot(e.getX()/100,e.getY()/100, true);
        }
        else{
            System.out.println("Currently selected piece: "+currentPiece);
            initX=currentPiece.getX()/100;
            initY=currentPiece.getY()/100;
            movePiece(e.getX()/100,e.getY()/100);
        }
    }

    /**
     * Metoda wyszukuje na polu pionek
     * @param x pozycja x
     * @param y pozycja y
     * @param remove czy usunąc elemnt z tablicy po jego znalezieniu?
     * @return znaleziony w punkcie pionek lub null
     */
    private Piece lookUpSpot(int x, int y, boolean remove){
        Piece tempPiece = board.lookUpSpot(x, y, true, player.getCurrentTurn());
        return tempPiece;
    }

    /**
     * Porusza pionek do punktu zadanego parametrami
     * @param x punkt x do ktorego nalezy przesunac pionek
     * @param y punkt y do ktorego nalezy przesunac pionek
     */
    private void movePiece(int x, int y){
        if(x==initX&&y==initY){
            board.returnPiece(currentPiece);
            currentPiece=null;
        }
        else if(currentPiece.isValidMove(x,y)){
            Piece destination = lookUpSpot(x, y, true);
            currentPiece.move(x, y);
            board.returnPiece(currentPiece);
            if (destination != null) {
                lookUpSpot(x,y,true);
                if(player.getCurrentTurn()== PieceColor.WHITE) player.whiteIncrement();
                else player.blackIncrement();
                System.out.println(player.toString());
            }
            player.switchTurn();
            currentPiece = null;
        }
        else System.out.println("Move is invalid!!!");
    }

    /**
     * Zwraca obecnie wybrany pionek
     * @return obecnie wybrany pionek
     */
    public Piece getCurrentPiece(){
        return currentPiece;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
