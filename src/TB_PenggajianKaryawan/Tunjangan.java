/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public abstract class Tunjangan {
    
    String id, nama;
 int gaji, tunjangan;

 private double nilaiGajiAkhir(){
 return (gaji+tunjangan);
 }

 double tampilGA(){
 return nilaiGajiAkhir();
 }
 abstract double nilaiGaji();
    
    
}
