package farstar;

public class VaisseauArmeLeger extends VaisseauArme {
    
    VaisseauArmeLeger(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.ARMELEGER);
        construire(args);
    }
    
    void equiper(Phaser arme) {
        if(!DB.produitDisponible(arme)) {
            return;
        }
        
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale) {
            elementCharges.put(arme.getNom(), arme);
            DB.ajouterProduitPlacer(arme);
        } else {
            capaciteAtteinteErreur();
        }
    }
}
