/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7.Polimorfisme_Exception;

/**
 *
 * @author ASUS
 */
public class Tabung extends Bentuk {
   int r = 3 ,t = 5;

    @Override
    double volume() {
    return ((3.14*r*r)*t);
    }
    
    @Override
    double luasPermukaan() {
    return ((2*3.14*r)*(r+t));
    }
}
