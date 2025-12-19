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
    private int score = 0; 
    private int nbcoups = 0;
    
    public jeu() {
        grille = new Grille();
        initialiser();
    }
    

    private void initialiser() {
            int tuilesAplacer = 9;
        
        while (tuilesAplacer > 0) {
            int ligne = (int)(Math.random() * 4);
            int colonne = (int)(Math.random() * 4);
            
            if (grille.estvide(ligne, colonne)) {

                int valeur = Math.random() < 0.5 ? 1 : 2;
                grille.ecrireCase(ligne, colonne, valeur);
                tuilesAplacer--;
            }
        }
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
        int resultat; 
        if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
            resultat= 3;
        } else {
            resultat= a + b;
        }
        score+=resultat;
        return resultat;
}
    private boolean deplacerCaseGauche(int ligne, int colonne) {
    int a = grille.lireCase(ligne, colonne);
    int b = grille.lireCase(ligne, colonne + 1);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, colonne, b);
        grille.ecrireCase(ligne, colonne + 1, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, colonne, fusion(a, b));
        grille.ecrireCase(ligne, colonne + 1, 0);
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
    private boolean deplacerCaseDroite(int ligne, int colonne) {
    int a = grille.lireCase(ligne, colonne);
    int b = grille.lireCase(ligne, colonne - 1);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, colonne, b);
        grille.ecrireCase(ligne, colonne - 1, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, colonne, fusion(a, b));
        grille.ecrireCase(ligne, colonne - 1, 0);
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
    private boolean deplacerCaseHaut(int ligne, int colonne) {
    int a = grille.lireCase(ligne, colonne);
    int b = grille.lireCase(ligne + 1, colonne);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, colonne, b);
        grille.ecrireCase(ligne + 1, colonne, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, colonne, fusion(a, b));
        grille.ecrireCase(ligne + 1, colonne, 0);
        return true;
    }

    return false;
}
    private void deplacerColonneHaut(int colonne) {
    for (int ligne = 0; ligne < 3; ligne++) {
        deplacerCaseHaut(ligne, colonne);
    }
}
    public void deplacerHaut() {
    for (int colonne = 0; colonne < 4; colonne++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerColonneHaut(colonne);
        }
    }
}
    private boolean deplacerCaseBas(int ligne, int colonne) {
    int a = grille.lireCase(ligne, colonne);
    int b = grille.lireCase(ligne - 1, colonne);

    if (a == 0 && b != 0) {
        grille.ecrireCase(ligne, colonne, b);
        grille.ecrireCase(ligne - 1, colonne, 0);
        return true;
    }

    if (peutFusionner(a, b)) {
        grille.ecrireCase(ligne, colonne, fusion(a, b));
        grille.ecrireCase(ligne - 1, colonne, 0);
        return true;
    }

    return false;
}
    private void deplacerColonneBas(int colonne) {
    for (int ligne = 3; ligne > 0; ligne--) {
        deplacerCaseBas(ligne, colonne);
    }
}
public void deplacerBas() {
    for (int colonne = 0; colonne < 4; colonne++) {
        for (int passage = 0; passage < 3; passage++) {
            deplacerColonneBas(colonne);
        }
    }
}
private int[][] copieGrille() {
    int[][] copie = new int[4][4];
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int colonne = 0; colonne < 4; colonne++) {
            copie[ligne][colonne] = grille.lireCase(ligne, colonne);
        }
    }
    return copie;
}
private boolean modifiee(int[][] avant) {
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int colonne = 0; colonne < 4; colonne++) {
            if (avant[ligne][colonne] != grille.lireCase(ligne, colonne)) {
                return true;
            }
        }
        
    }
    return false;
}
private void ajouterTuile() {
    int ligne;
    int colonne;
    boolean caseVideTrouvee = false;
        
    while (caseVideTrouvee == false) {
        ligne = (int)(Math.random() * 4);
        colonne = (int)(Math.random() * 4);
// on vérifie si cette case est vide
        if (grille.estvide(ligne, colonne)) {
        // si case vide trouvée alors on sort de la boucle
            caseVideTrouvee = true;

            int valeur;
            if (Math.random() < 0.5) {
                valeur = 1;
            } else {
                valeur = 2;
            }

            grille.ecrireCase(ligne, colonne, valeur);
            }
        }
    }
public void jouerGauche() {
    if (estFini()) return;
    
    int[][] avant = copieGrille();
    deplacerGauche();
    if (modifiee(avant)) {
        ajouterTuile();
        nbcoups++;
    }
}

public void jouerDroite() {
    if (estFini()) return;
    
    int[][] avant = copieGrille();
    deplacerDroite();
    if (modifiee(avant)) {
        ajouterTuile();
        nbcoups++;
    }
}

public void jouerHaut() {
    if (estFini()) return;
    
    int[][] avant = copieGrille();
    deplacerHaut();
    if (modifiee(avant)) {
        ajouterTuile();
        nbcoups++;
    }
}

public void jouerBas() {
    if (estFini()) return;
    
    int[][] avant = copieGrille();
    deplacerBas();
    if (modifiee(avant)) {
        ajouterTuile();
        nbcoups++;
    }
}
private boolean deplacementPossible() {
    for (int ligne = 0; ligne < 4; ligne++) {
        for (int colonne = 0; colonne < 4; colonne++) {
            int valeur = grille.lireCase(ligne, colonne);

            if (valeur == 0) return true;

            if (colonne < 3 && peutFusionner(valeur, grille.lireCase(ligne, colonne + 1)))
                return true;

            if (ligne < 3 && peutFusionner(valeur, grille.lireCase(ligne + 1, colonne)))
                return true;
        }
    }
    return false;
}
public boolean estFini() {
    return !deplacementPossible();
}
public int getValeur(int ligne, int colonne) {
    return grille.lireCase(ligne, colonne);
}

public boolean estVide(int ligne, int colonne) {
    return grille.estvide(ligne, colonne);
}
public int Score(){
    return score;
}
public int coups(){
    return nbcoups;
    
}
}

