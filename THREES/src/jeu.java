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
    private boolean deplacerCaseGauche(int ligne, int col) {
    int a = grille.lireCase(ligne, col);
    int b = grille.lireCase(ligne, col + 1);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, col, b);
        grille.ecrireCase(ligne, col + 1, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, col, fusion(a, b));
        grille.ecrireCase(ligne, col + 1, 0);
        return true;
    }

    return false;
    }
    private void deplacerLigneGauche(int ligne) {
    for (int i = 0; i < 3; i++) {
        deplacerCaseGauche(ligne, i);
    }
}
    public void deplacerGauche() {
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerLigneGauche(ligne);
        }
    }
}
    private boolean deplacerCaseDroite(int ligne, int col) {
    int a = grille.lireCase(ligne, col);
    int b = grille.lireCase(ligne, col - 1);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, col, b);
        grille.ecrireCase(ligne, col - 1, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, col, fusion(a, b));
        grille.ecrireCase(ligne, col - 1, 0);
        return true;
    }

    return false;
}
    private void deplacerLigneDroite(int ligne) {
    for (int col = 3; col > 0; col--) {
        deplacerCaseDroite(ligne, col);
    }
}
    public void deplacerDroite() {
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerLigneDroite(ligne);
        }
    }
}
    private boolean deplacerCaseHaut(int ligne, int col) {
    int a = grille.lireCase(ligne, col);
    int b = grille.lireCase(ligne + 1, col);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, col, b);
        grille.ecrireCase(ligne + 1, col, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, col, fusion(a, b));
        grille.ecrireCase(ligne + 1, col, 0);
        return true;
    }

    return false;
}
    private void deplacerColonneHaut(int col) {
    for (int ligne = 0; ligne < 3; ligne++) {
        deplacerCaseHaut(ligne, col);
    }
}
    public void deplacerHaut() {
    for (int col = 0; col < 4; col++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerColonneHaut(col);
        }
    }
}
    private boolean deplacerCaseBas(int ligne, int col) {
    int a = grille.lireCase(ligne, col);
    int b = grille.lireCase(ligne - 1, col);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, col, b);
        grille.ecrireCase(ligne - 1, col, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, col, fusion(a, b));
        grille.ecrireCase(ligne - 1, col, 0);
        return true;
    }

    return false;
}
    private void deplacerColonneBas(int col) {
    for (int ligne = 3; ligne > 0; ligne--) {
        deplacerCaseBas(ligne, col);
    }
}
public void deplacerBas() {
    for (int col = 0; col < 4; col++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerColonneBas(col);
        }
    }
}
}

