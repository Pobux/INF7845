package farstar;

public class VaisseauArmeLeger extends VaisseauArme {
    
    VaisseauArmeLeger(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.ARMELEGER);
        construire(args);
    }
    
    void equiper(Phaser arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximaleArme) {
            elementCharges.put(arme.getNom(), arme);
            DB.ajouterProduitPlacer(arme);
        } else {
            capaciteAtteinteErreur();
        }
    }
}
