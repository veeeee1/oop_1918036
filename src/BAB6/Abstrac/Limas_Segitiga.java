/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB6.Abstrac;

/**
 *
 * @author ASUS
 */
public class Limas_Segitiga extends Segitiga {
    double t,vol;
    
    @Override
    double Volume(){
       vol = (Luas()*t/3);
       return vol;
    }
    
}
