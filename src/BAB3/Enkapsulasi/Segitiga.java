/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB3.Enkapsulasi;

/**
 *
 * @author ASUS
 */
public class Segitiga {
    private double Alas;
    public double tinggi, Luas;
    
    public void setAlas(double a ){
        this.Alas = a;
        
    }
    
    public double getAlas(){
        return Alas;
    }
    
    double Luas(){
        Luas = getAlas() * tinggi / 2;
        return Luas;
    }
    
}
