/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maier
 */
public class jeu {
    private Grille grille;

    public jeu() {
        grille = new Grille();
        initialiser();
    }

    private void initialiser() {
        // pour l’instant, on met quelques valeurs à la main
        grille.ecrireCase(0, 0, 1);
        grille.ecrireCase(0, 1, 2);
    }

    public void afficher() {
        grille.afficher();
    }
}

