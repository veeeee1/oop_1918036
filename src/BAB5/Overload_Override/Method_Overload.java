/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB5.Overload_Override;

/**
 *
 * @author ASUS
 */
public class Method_Overload {
    
    int Luas(int p){
        return p;
    }
    
    Double Luas(double p){
        return p;
    }
    
    Double Jumlah(double n, int m){
        return m+n;
    }
    
    int Volume(){
        int p=2, l=3, t=4;
        return p*l*t;
    }
}
