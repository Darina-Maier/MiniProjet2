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
    private boolean peutFusionner(int a, int b) {
    if (a == 0 || b == 0) return false;

    if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
        return true;
    }

    if (a >= 3 && a == b) {
        return true;
    }

    return false;
}
    private int fusion(int a, int b) {
    if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
        return 3;
    }
    return a + b;
}
    public void deplacerGauche() {
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int col = 0; col < 3; col++) {
            int a = grille.lireCase(ligne, col);
            int b = grille.lireCase(ligne, col + 1);

            if (a == 0 && b != 0) {
                grille.ecrireCase(ligne, col, b);
                grille.ecrireCase(ligne, col + 1, 0);
            }
            else if (peutFusionner(a, b)) {
                grille.ecrireCase(ligne, col, fusion(a, b));
                grille.ecrireCase(ligne, col + 1, 0);
            }
        }
    }
    }
}

