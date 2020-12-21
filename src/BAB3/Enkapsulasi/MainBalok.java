/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB3.Enkapsulasi;

/**
 *
 * @author ASUS
 */
public class MainBalok {
    public static void main(String[] args) {
        HitungBalok data = new HitungBalok();
        
        data.panjang = 30;
        data.lebar = 15;
        data.tinggi =5; 
        
        System.out.println("volume : " + data.TampilanBalok());
    }
}
