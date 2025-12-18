/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author maier
 */
public class THREES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jeu j = new jeu();
        j.afficher();
        System.out.println("Déplacement gauche");
        j.deplacerGauche();
        j.afficher();
    }
}
