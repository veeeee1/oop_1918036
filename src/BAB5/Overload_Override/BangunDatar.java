/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB5.Overload_Override;

/**
 *
 * @author ASUS
 */
public class BangunDatar {
    
    //method yang akan di overriding
    public double Luas(double p, double l){
        return (p*l);
    }
    
    public double Luas(double r){
        return (2*3.14*r);
    }
}
