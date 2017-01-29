package farstar;

public class VaisseauArmeLeger extends VaisseauArme {
    
    public VaisseauArmeLeger(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.ARMELEGER);
        construire(args);
    }
    
    public void equiper(Phaser arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale ) {
            elementCharges.put(arme.getNom(), arme);
            DB.ajouterProduitPlacer(arme);
        } else {
            capaciteAtteinteErreur();
        }
    }
}
