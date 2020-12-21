/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB3.Enkapsulasi;

/**
 *
 * @author ASUS
 */
public class MainSegitiga {
    public static void main(String[] args){
        Segitiga segitiga = new Segitiga();
        segitiga.tinggi = 5;
        segitiga.setAlas(6.5);
        System.out.println("Luas : " + Double.toString(segitiga.Luas()));
        
    }
}
