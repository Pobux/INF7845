package farstar;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FarStarAPI {
    Map<String, Vaisseau> VaisseauMap = new HashMap();
    Map<String, Arme> ArmeMap = new HashMap();
    
    public FarStarAPI() {
        
    }
    
    public Transportable creer(String nom, Object[] args) {
        if(valideNom(nom)) {
            try {
                return UsineDeLespace.creerProduit(nom, args);    
            } catch(nonConstructionException nc) {
                System.out.println(nc.toString());
            }
        } else {
            System.out.println("Erreur : Le nom est invalide. Il doit respecter "
                + "le format suivant : [A-Z]{2}-[0-9]+ , e.g.: VT-10");
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

            return false;
        }
    }
    
    private boolean validationUnique(String nom) {
        for (Map.Entry<String, Vaisseau> vaisseau : VaisseauMap.entrySet()) {
            String key = vaisseau.getKey();
            if(nom.equals(key)) {
                System.out.println("Erreur : un vaisseau de ce nom existe déjà.");
                return false;
            }
        }
        
        for (Map.Entry<String, Arme> arme : ArmeMap.entrySet()) {
            String key = arme.getKey();
            if(nom.equals(key)) {
                System.out.println("Erreur : une arme de ce nom existe déjà.");
                return false;
            }
        }
        
        return true;
    }
    
    
    
    
}
