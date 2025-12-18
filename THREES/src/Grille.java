/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maier
 */
public class Grille { // on crée une grille (matrice) 4x4
    private int [][] cases; 

    public Grille() {
        cases = new int[4][4];
    }

    public int lireCase (int ligne, int colonne) {
        return cases [ligne][colonne];
    }
    public void ecrireCase (int ligne, int colonne, int valeur) {
        cases [ligne][colonne] = valeur;
    }
    public boolean estvide (int ligne, int colonne){
        return cases [ligne][colonne] == 0; 
    }
    public void afficher (){
        for (int ligne = 0; ligne < 4; ligne++) {
            
            for (int colonne = 0; colonne < 4; colonne++) {
                System.out.print(cases[ligne][colonne]);
            }
        System.out.println();
        }
    } 
}

