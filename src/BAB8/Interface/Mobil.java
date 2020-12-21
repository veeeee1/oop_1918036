/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB8.Interface;

/**
 *
 * @author ASUS
 */
public class Mobil implements Kendaraan {
    
    @Override
    public String nama(){
        return "Mesin";
    }
    
    @Override 
    public int jumlah_roda(){
        return 4;
    }
    
    @Override
    public String lintasan(){
        return "Aspal";
    }
    
}
    
    
