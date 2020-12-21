/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB4.Inheritance;

/**
 *
 * @author ASUS
 */
public class Prisma_Segitiga extends Segitiga {
   double t, vol;
    double volumePrisma (){
        vol = (Luas ()*t);
        return vol;
    } 
}
