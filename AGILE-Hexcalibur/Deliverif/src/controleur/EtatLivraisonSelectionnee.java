/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import deliverif.Deliverif;
import modele.outils.GestionLivraison;
import modele.outils.PointPassage;

/**
 *
 * @author Amine Nahid
 */
public class EtatLivraisonSelectionnee extends EtatDefaut {
    
    private PointPassage livraisonASupprimer;

    public EtatLivraisonSelectionnee() {
    }
    
    public void actionEntree(PointPassage intersectionASupprimer){
        this.livraisonASupprimer = intersectionASupprimer;
    }
    
    /**
     *
     * @param gestionLivraison
     * @param fenetre
     * @param latitude
     * @param longitude
     */
    @Override
    public void selectionnerPoint (GestionLivraison gestionLivraison, Deliverif fenetre, double latitude, double longitude) {
        PointPassage pointClique = gestionLivraison.pointPassagePlusProche(latitude, longitude);
        fenetre.estPointPassageSelectionne(latitude, longitude);
        Controleur.etatCourant = Controleur.ETAT_LIVRAISON_SELECTIONNEE;
    }
    
    @Override
    public void annuler(deliverif.Deliverif fenetre){
        Controleur.etatCourant = Controleur.ETAT_TOURNEES_CALCULEES;
    }
    
    @Override
    public void validerSuppression (GestionLivraison gestionLivraison, deliverif.Deliverif fenetre) {
        gestionLivraison.supprimerLivraison(livraisonASupprimer);
        Controleur.etatCourant = Controleur.ETAT_TOURNEES_CALCULEES;
    }
}
