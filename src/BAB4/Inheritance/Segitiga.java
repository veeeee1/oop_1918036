/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB4.Inheritance;

/**
 *
 * @author ASUS
 */
public abstract class Segitiga {
    double alas,tinggi,luas;
    double Luas(){
        luas = 0.5*(alas *tinggi);
        return luas;
    }  
}
