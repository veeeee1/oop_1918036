/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB3.Enkapsulasi;

/**
 *
 * @author ASUS
 */
public class HitungBalok {
    public double panjang, lebar, tinggi;
    double volume;
    
    private double volumeBalok(){
        return panjang * lebar * tinggi;
    }
    
    public double tampilBalok(){
        return volumeBalok();
    }

    String TampilanBalok() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
