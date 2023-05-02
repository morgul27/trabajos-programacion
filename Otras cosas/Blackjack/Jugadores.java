package Blackjack;

import java.util.ArrayList;

public class Jugadores {
    protected ArrayList<String> manol = new ArrayList<String>(); // letras mostrar cartas
    protected int manon; // para la suma de cartas
    // deberia de hacer un metodo "suma" para sumar cada vez que quiera y asi
    // guardar los resultados en un ArrayList

    public Jugadores() {
    }

    public ArrayList<String> getManol() {
        return manol;
    }

    public void setManol(String manol) {
        this.manol.add(manol);
    }

    public int getManon() {
        return manon;
    }

    public void setManon(int manon) {
        this.manon = this.manon + manon;
    }

    public String toString() {
        return "Tu mano tiene un " + manol + " y su suma total es " + manon;
    }

}
