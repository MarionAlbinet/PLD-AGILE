/*
 * Projet Deliverif
 *
 * Hexanome n° 41
 *
 * Projet développé dans le cadre du cours "Conception Orientée Objet
 * et développement logiciel AGILE".
 */
package controleur;

/** Classe mère de tous les états.
 * Améliore la visibilité du code, dans les classes filles on implémente 
 * seulement les méthodes ayant un traitement particulier. 
 *
 * @author Hex'calibur
 */

public class EtatDefaut implements Etat
{

    /**
     * Constructeur EtatDefaut
     */
    public EtatDefaut (){}
    
    /**
     * @param gestionLivraison
     * @param fichier
     * @param fenetre
     * @see modele.GestionLivraison
     * @version 1
     */
    @Override
    public void chargePlan (modele.outils.GestionLivraison gestionLivraison, String fichier, deliverif.Deliverif fenetre){
    }
    
    /**
     * @param gestionLivraison
     * @param fichier
     * @param fenetre
     * @see modele.GestionLivraison
     * @version 1
     */
    @Override
    public void chargeLivraisons (modele.outils.GestionLivraison gestionLivraison, String fichier, deliverif.Deliverif fenetre){
    }
    
    /**
     * @param gestionLivraison
     * @param nbLivreurs
     * @param fenetre
     * @see modele.GestionLivraison
     * @version 1
     */
    @Override
    public void calculerTournees(modele.outils.GestionLivraison gestionLivraison, int nbLivreurs, deliverif.Deliverif fenetre){
    }
}