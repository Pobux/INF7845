package farstar;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FarStarAPI {
    Manager BD;
    
    public FarStarAPI() {
        BD = Manager.getInstance();
    }
    
    public Transportable creer(String nom, Object[] args) {
        if(valideNom(nom)) {
            try {
                Transportable produit = UsineFarStar.creerProduit(nom, args);
                BD.ajouterProduitCree(produit);
                return produit;
            } catch(nonConstructionException nc) {
                System.out.println(nc.toString());
            }
        }
        
        return null;
    }
    
    private boolean valideNom(String nom) {
        
        return validationRegex(nom) && validationUnique(nom);
    }
    
    private boolean validationRegex(String nom) {
        /*
        Un nom doit commencer par deux lettres majuscules, suivi d'un tiret et
        un nombre de chiffre quelconque. "(^[A-Z]{2}-[0-9]+$)"
        */
        String pattern = "(^[A-Z]{2}-[0-9]+$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(nom);
        if(m.find()) {
            return true;
        } else {
            System.out.println("Erreur : Le nom est invalide. Il doit respecter "
                + "le format suivant : [A-Z]{2}-[0-9]+ , e.g.: VT-10");
            return false;
        }
    }
    
    private boolean validationUnique(String nom) {
        for (Map.Entry<String, Transportable> vaisseau : BD.produitCree.entrySet()) {
            String key = vaisseau.getKey();
            if(nom.equals(key)) {
                System.out.println("Erreur : Un produit de ce nom existe déjà.");
                return false;
            }
        }
        
        return true;
    }
    
    public void equiperVaisseauLourd(VaisseauArmeLourd vaisseau, Arme arme) {
        vaisseau.equiper(arme);
    }
    
    public void equiperVaisseauLeger(VaisseauArmeLeger vaisseau, Phaser arme) {
        vaisseau.equiper(arme);
    }
    
    public Arme desequiperVaisseau(VaisseauArme vaisseau, String nomArme) {
        return vaisseau.desequiper(nomArme);
    }
    
    public void charger(Chargeable vaisseau, Transportable produit) {
        vaisseau.charger(produit);
    }
    
    public Transportable decharger(Chargeable vaisseau, String nomProduit) {
        return vaisseau.decharger(nomProduit);
    }
    
    public Vaisseau localiser(Transportable element) {
        List<Vaisseau> listeVaisseau = BD.getListeVaisseau();
        for (int i = 0; i < listeVaisseau.size(); i++) {
            Vaisseau v = listeVaisseau.get(i);
            System.out.println(v);
            Vaisseau trouver = v.localiser(element);
            if(trouver != null) {
                System.out.println(element.getNom() + " est dans " + trouver.getNom());
                return trouver;
            }
        }
        
        return null; //aucun résultat n'a été trouvé
    }
 }
