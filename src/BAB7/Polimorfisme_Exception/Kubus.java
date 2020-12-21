/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7.Polimorfisme_Exception;

/**
 *
 * @author ASUS
 */
public class Kubus extends Bentuk {
    int s = 8;

    @Override
    double volume() {
    return(s*s*s);
    }
    
    @Override
    double luasPermukaan() {
    return (6*(s*s));
    } 
    
}
