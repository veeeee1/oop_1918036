/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB6.Abstrac;

/**
 *
 * @author ASUS
 */
public class Prisma_Segitiga extends Segitiga {
    double t, vol;
    
    double Volume(){
        vol = (Luas()*t);
        return vol;
    } 
    
}
