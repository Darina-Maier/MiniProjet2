/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author maier
 */
public class CelluleGraphique extends JButton {
    private int ligne;
    private int colonne;
    private jeu jeu;

    public CelluleGraphique(jeu jeu, int ligne, int colonne) {
        this.jeu = jeu;
        this.ligne = ligne;
        this.colonne = colonne;

        setFont(new Font("Arial", Font.BOLD, 24));
        setFocusable(false);
        miseAJourCellule();
    }

    public void miseAJourCellule() {
        int valeur = jeu.getValeur(ligne, colonne);

        if (valeur == 0) {
            setText("");
            setBackground(Color.LIGHT_GRAY);
        } else {
            setText(String.valueOf(valeur));
            setBackground(Color.WHITE);
        }
    }
}
