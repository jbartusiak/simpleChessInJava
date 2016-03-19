package com.ambiguous.logic.raw;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Kubuś on 2016-03-19.
 */
public abstract class PieceIdentity {
    static String workingDir = System.getProperty("user.dir")+"\\src\\com\\ambiguous\\assets";
    public static BufferedImage PAWN_WHITE;
    public static BufferedImage PAWN_BLACK;
    public static BufferedImage BISHOP_WHITE;
    public static BufferedImage BISHOP_BLACK;
    public static BufferedImage ROOK_WHITE;
    public static BufferedImage ROOK_BLACK;
    public static BufferedImage KNIGHT_WHITE;
    public static BufferedImage KNIGHT_BLACK;
    public static BufferedImage QUEEN_WHITE;
    public static BufferedImage QUEEN_BLACK;
    public static BufferedImage KING_WHITE;
    public static BufferedImage KING_BLACK;

    public static void loadAssets(){
        try{
            PAWN_WHITE = ImageIO.read(new File(workingDir+"\\pawn_white.png"));
            PAWN_BLACK = ImageIO.read(new File(workingDir+"\\pawn_black.png"));
            BISHOP_WHITE = ImageIO.read(new File(workingDir+"\\bishop_white.png"));
            BISHOP_BLACK = ImageIO.read(new File(workingDir+"\\bishop_black.png"));
            ROOK_WHITE = ImageIO.read(new File(workingDir+"\\rook_white.png"));
            ROOK_BLACK = ImageIO.read(new File(workingDir+"\\rook_black.png"));
            KNIGHT_WHITE = ImageIO.read(new File(workingDir+"\\knight_white.png"));
            KNIGHT_BLACK = ImageIO.read(new File(workingDir+"\\knight_black.png"));
            QUEEN_WHITE = ImageIO.read(new File(workingDir+"\\queen_white.png"));
            QUEEN_BLACK = ImageIO.read(new File(workingDir+"\\queen_black.png"));
            KING_WHITE = ImageIO.read(new File(workingDir+"\\king_white.png"));
            KING_BLACK = ImageIO.read(new File(workingDir+"\\king_black.png"));
        }

        catch(IOException e){

        }
    }
}
