package farstar;
import java.util.*;

class Manager {
    /*
    Une base de données aurait été plus intéressante mais hors 
    sujet de ce TP.
    */
    Map<String, Transportable> produitCree;
    Map<String, Transportable> produitPlacer;

    private static Manager instance = null;

    protected Manager() {}

    public static Manager getInstance() {
       if(instance == null) {
          instance = new Manager();
       }
       return instance;
    }

    public void ajouterProduitCree(Transportable produit) {
        produitCree.put(produit.getNom(), produit);
    }
    
    public void ajouterProduitPlacer(Transportable produit) {
        produitPlacer.put(produit.getNom(), produit);
    }

    public void retirerProduitPlacer(Transportable produit) {
        produitPlacer.remove(produit.getNom());
    }

    public boolean produitDisponible(Transportable produit) {
        return produitCree.containsKey(produit.getNom()) &&
                !produitPlacer.containsKey(produit.getNom());
    }
    
    public List<Vaisseau> getListeVaisseau() {
        List<Vaisseau> listeVaisseau = new ArrayList();
        
        for (Map.Entry<String, Transportable> e : produitCree.entrySet()) {
            Transportable value = e.getValue();
            
            if(value.getClass().isInstance(Vaisseau.class)) {
                listeVaisseau.add((Vaisseau) value);
            }
        }
        
        return listeVaisseau;
    }
}