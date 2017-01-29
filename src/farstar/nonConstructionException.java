package farstar;

public class nonConstructionException extends Exception {

    public nonConstructionException() {
    }

    public nonConstructionException(String msg) {
        super(msg);
    }
}
