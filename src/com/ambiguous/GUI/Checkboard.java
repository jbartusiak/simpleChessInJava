package com.ambiguous.GUI;

import com.ambiguous.logic.listeners.ChessBoardListener;
import com.ambiguous.logic.raw.Piece;
import com.ambiguous.logic.raw.PieceColor;
import com.ambiguous.logic.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Kubuś on 2016-03-18.
 */
public class Checkboard extends JComponent {
    /**
     * @param piecesList - lista zawierajaca pionki
     * @param picture - obraz na ktorym rysowana jest plansza i pionki
     * @param mainFrame - glowne okno aplikacji
     * @param ctx - konteks graficzy
     * @param m_size - rozmiar okna i kanwy
     * @param listener - obiekt implementujący MouseListener i obsługujący wydarzenia na polu
     */
    private ArrayList<Piece> piecesList;
    private BufferedImage picture;
    private JFrame mainFrame;
    private Graphics2D ctx;
    private final Dimension m_size;
    private ChessBoardListener listener;

    /**
     * Konstruktor
     */
    public Checkboard(){
        m_size = new Dimension(800,800);
        initializeFrame();

        setPreferredSize(m_size);
        setMinimumSize(m_size);

        addComponents();
        piecesList = new ArrayList<>();

        addPieces();

        listener= new ChessBoardListener(this);

        addMouseListener(listener);
    }

    /**
     * Metoda dodaje (inicjalizuje) pionki w grze
     */
    private void addPieces(){
        for (int i=0; i<8; i++){
            piecesList.add(new Pawn(i*100,600, PieceColor.WHITE));
            piecesList.add(new Pawn(i*100,100, PieceColor.BLACK));
        }
        piecesList.add(new Rook(0,700, PieceColor.WHITE));
        piecesList.add(new Rook(700,700,PieceColor.WHITE));
        piecesList.add(new Knight(100,700,PieceColor.WHITE));
        piecesList.add(new Knight(600,700,PieceColor.WHITE));
        piecesList.add(new Bishop(200,700,PieceColor.WHITE));
        piecesList.add(new Bishop(500,700,PieceColor.WHITE));
        piecesList.add(new King(300,700,PieceColor.WHITE));
        piecesList.add(new Queen(400,700,PieceColor.WHITE));

        piecesList.add(new Rook(0,0, PieceColor.BLACK));
        piecesList.add(new Rook(700,0,PieceColor.BLACK));
        piecesList.add(new Knight(100,0,PieceColor.BLACK));
        piecesList.add(new Knight(600,0,PieceColor.BLACK));
        piecesList.add(new Bishop(200,0,PieceColor.BLACK));
        piecesList.add(new Bishop(500,0,PieceColor.BLACK));
        piecesList.add(new King(300,0,PieceColor.BLACK));
        piecesList.add(new Queen(400,0,PieceColor.BLACK));
    }

    /**
     * Metoda inicjalizuje komponenty
     */
    private void addComponents(){
        mainFrame.add(this);
        mainFrame.pack();
    }

    /**
     * Metoda inicjalizuje okno w którym rysowana jest gra
     */
    private void initializeFrame(){
        mainFrame = new JFrame("Checkboard");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    /**
     * Metoda rysuje obraz umieszony w zmiennej picture
     * @param g Kontekt graficzny komponentu
     */
    @Override
    public void paintComponent(Graphics g) {
        if(picture==null) {
            picture = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
            ctx = picture.createGraphics();
            ctx.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        }
        clear(ctx);
        drawCheckboard(ctx);

        drawChess(ctx);
        g.drawImage(picture,0,0,null);
    }

    /**
     * Metoda rysuje szachy na polu
     * @param g Kontekt graficzny obrazu, na którym narysowano planszę
     */
    private void drawChess(Graphics2D g){
        for(int i=0; i<piecesList.size();i++){
            piecesList.get(i).drawObject(g);
        }

        Piece currentPiece = listener.getCurrentPiece();

        if(currentPiece!=null){
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(2.0f));
            g.drawRect(currentPiece.getX(),currentPiece.getY(),100,100);
            currentPiece.drawObject(g);
        }
        repaint();
    }

    /**
     * Metoda czyści obiekt graficzny
     * @param g kontakt graficzny do wyczyszczenia
     */
    private void clear(Graphics2D g){
        g.setColor(Color.GRAY);
        g.fillRect(0,0,800,800);
    }

    /**
     * Metoda rysuje szachownicę
     * @param g Kontekst na którym należy naryzoswać szachownice
     */
    private void drawCheckboard(Graphics2D g){
        g.setColor(Color.WHITE);
        for (int y=0; y<=8; y++){
            for (int x=0; x<=8; x++){
                if(y%2==0) {
                    if(x%2==0) {
                        g.fillRect(100 * x, 100 * y, 100, 100);
                    }
                }
                else{
                    if(x%2==1){
                        g.fillRect(100 * x, 100 * y, 100, 100);
                    }
                }
            }
        }
    }

    /**
     * Metoda sprawdza, czy w punkcie zadanym parametrami x i y znajduje się jakiś pinek.
     * @param x pole x (liczba naturalna 0-7)
     * @param y pole y (liczba naturalna 0-7)
     * @param remove Jeżeli true, to znaleziony pionek powinien zostać usunięty z planszy.
     * @return Pionek znaleziony w punkcie lub null gdy w danym punkcie nie ma pionka
     */
    public Piece lookUpSpot(int x, int y, boolean remove){
        Piece pieceFound = null;
        x*=100;
        y*=100;
        for (int i=0; i<piecesList.size();i++){
            Piece currentPiece = piecesList.get(i);
            if(x==currentPiece.getX()&&y==currentPiece.getY()) {
                pieceFound = currentPiece;
                if(remove) piecesList.remove(i);
                break;
            }
        }
        return pieceFound;
    }

    /**
     * Metoda pozwala zewnętrznym obiektom dodać (lub oddać) pionek na planszę.
     * @param piece Pionek który ma zostać dodany
     */
    public void returnPiece(Piece piece){
        piecesList.add(piece);
    }
}
