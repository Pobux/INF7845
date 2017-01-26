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
public class Phaser extends Arme {
    
    public Phaser(String nom, int masse, int volume) {
        super(nom, masse, volume);
    }
    
    public void fire() {
        System.out.println("fire phaser");
    }
}
