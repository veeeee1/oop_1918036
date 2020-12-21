/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7.Polimorfisme_Exception;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Lat_Exception {
    public static void main(String[] args) {
    int a=5 ,b=10 ,hasil;

    try{
        hasil = b/a;
    }catch(ArithmeticException c){
        JOptionPane.showMessageDialog(null, "Nilai pembagi tidak boleh 0 !!", "Warning",2);
    }catch(NumberFormatException d){
        JOptionPane.showMessageDialog(null, "Karena pembaginya huruf !!", "Warning",2);
    }finally{
        System.out.println("Trimakasi sudah menjalankan program");
    }
  
  }

}
