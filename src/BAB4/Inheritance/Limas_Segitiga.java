/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB4.Inheritance;

/**
 *
 * @author ASUS
 */
public class Limas_Segitiga extends Segitiga {
    double t,vol;
    double volumeLimas(){
       vol = (Luas()*t)/3;
       return vol;
    } 
}
