/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public abstract class Penggajian {
    String nama, kode, jabatan;
    int gaji, tunjangan;
    String nama1, kd1, jbtn1, gaji1, tjgn1, ga1; 
    
    private double GajiAkhir(){
        return ((gaji)+(tunjangan));
    }

    double tampilGA(){
        return GajiAkhir();
    }
    
    abstract double gajiAkhir();
}
