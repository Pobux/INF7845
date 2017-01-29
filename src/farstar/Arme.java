package farstar;

public abstract class Arme extends Transportable {
    public Arme(TypeProduit type) {
        super(type); //Même les classes abstraites doivent avoir un constructeur
    }
}