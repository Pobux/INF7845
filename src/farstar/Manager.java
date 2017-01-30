package farstar;
import java.util.*;

class Manager {
    /*
    Une base de données aurait été plus intéressante mais hors 
    sujet de ce TP.
    */
    Map<String, Transportable> produitCree = new HashMap();
    Map<String, Transportable> produitPlacer = new HashMap();

    private static Manager instance = null;

    protected Manager() {}

    static Manager getInstance() {
       if(instance == null) {
          instance = new Manager();
       }
       return instance;
    }

    void ajouterProduitCree(Transportable produit) {
        produitCree.put(produit.getNom(), produit);
    }
    
    void ajouterProduitPlacer(Transportable produit) {
        produitPlacer.put(produit.getNom(), produit);
    }

    void retirerProduitPlacer(Transportable produit) {
        produitPlacer.remove(produit.getNom());
    }

    boolean produitDisponible(Transportable produit) {
        boolean resultat = produitCree.containsKey(produit.getNom()) &&
                !produitPlacer.containsKey(produit.getNom());
        
        if(!resultat) {
            System.out.println("Erreur : " + produit.getNom() + " est déjà placé.");
        }
        
        return resultat;
    }
    
    List<Vaisseau> getListeVaisseau() {
        List<Vaisseau> listeVaisseau = new ArrayList();
        
        for (Map.Entry<String, Transportable> e : produitCree.entrySet()) {
            Transportable value = e.getValue();

            if(Vaisseau.class.isInstance(value)) {
                System.out.println(value);
                listeVaisseau.add((Vaisseau) value);
            }
        }
        
        return listeVaisseau;
    }
}