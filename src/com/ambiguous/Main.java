package com.ambiguous;

import com.ambiguous.GUI.Checkboard;
import com.ambiguous.logic.raw.PieceIdentity;

public class Main {
    public static void main(String[] args) {
        PieceIdentity.loadAssets();
        new Checkboard();
    }
}
