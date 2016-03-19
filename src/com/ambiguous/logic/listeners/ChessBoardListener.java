package com.ambiguous.logic.listeners;

import com.ambiguous.GUI.Checkboard;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.Player;

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
            System.out.println("looking up");
            currentPiece=lookUpSpot(e.getX()/100,e.getY()/100, true);
        }
        else{
            initX=currentPiece.getX()/100;
            System.out.println(initX);
            initY=currentPiece.getY()/100;
            System.out.println(initY);
            movePiece(e.getX()/100,e.getY()/100);
        }
    }

    private Piece lookUpSpot(int x, int y, boolean remove){
        Piece tempPiece = board.lookUpSpot(x, y, true, player.getCurrentTurn());
        return tempPiece;
    }

    private void movePiece(int x, int y){
        System.out.println(x);
        System.out.println(y);
        if(x==initX&&y==initY){
            board.returnPiece(currentPiece);
            System.out.println(currentPiece.toString()+" was put back");
            currentPiece=null;
        }
        else if(currentPiece.isValidMove(x,y)){
            Piece destination = lookUpSpot(x, y, true);
            currentPiece.move(x, y);
            board.returnPiece(currentPiece);
            if (destination != null) {
                System.out.println("Removed " + destination.toString());
            }
            player.switchTurn();
            currentPiece = null;
        }
        else System.out.println("Move is invalid!!!");
    }

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
