/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farstar;

/**
 *
 * @author pobe
 */
public class Blaster extends Arme {
    
    public Blaster(String nom, int masse, int volume) {
        super(nom, masse, volume);
    }
    
    public void fire() {
        System.out.println("fire blaster");
    }
}
