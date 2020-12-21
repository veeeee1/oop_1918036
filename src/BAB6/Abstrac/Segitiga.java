/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB6.Abstrac;

/**
 *
 * @author ASUS
 */
public abstract class Segitiga {
    double alas,tinggi,luas;
    
    abstract double Volume();
    
    double Luas(){
        luas = 0.5*(alas *tinggi);
        return luas;
    }  
}

