/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.commandes;

import modele.outils.GestionLivraison;
import modele.outils.PointPassage;

/**
 *
 * @author lohl
 */
public class CdeDeplacerLivraison extends Commande{
    
    private PointPassage livraisonDeplacee;
    private int numeroTournee;
    private int ancienIndice;
    private int nouvelIndice;
    
    public CdeDeplacerLivraison(GestionLivraison gestion, PointPassage p, int numeroTournee, int nouvelIndice){
        super(gestion);
        this.numeroTournee=numeroTournee;
        this.nouvelIndice=nouvelIndice;
        this.ancienIndice=this.gestion.positionPointDansTournee(this.numeroTournee, p);
        this.livraisonDeplacee=p;
    }
    
    @Override
    public void doCde(){
        if(this.etatCommande==EtatCommande.EXECUTEE){
            return;
        }
        this.gestion.supprimerLivraison(this.livraisonDeplacee);
        this.gestion.ajouterLivraison(this.livraisonDeplacee, this.numeroTournee, this.nouvelIndice+(this.nouvelIndice>this.ancienIndice ? -1:0));
        
        this.etatCommande=EtatCommande.EXECUTEE;
    }
    
    @Override
    public void undoCde(){
        if(this.etatCommande==EtatCommande.ANNULEE){
            return;
        }
        this.gestion.supprimerLivraison(this.livraisonDeplacee);
        this.gestion.ajouterLivraison(this.livraisonDeplacee, this.numeroTournee, this.ancienIndice+(this.ancienIndice>this.nouvelIndice ? -1 : 0));
        this.etatCommande=EtatCommande.ANNULEE;
    }
    
}