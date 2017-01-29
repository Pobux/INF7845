package farstar;

public abstract class Arme extends Transportable {
    public Arme(String nom, TypeProduit type) {
        super(nom, type); //Même les classes abstraites doivent avoir un constructeur
    }
}