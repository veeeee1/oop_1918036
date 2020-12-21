/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Data_Penggajian {
    protected String nama, kode, tunjangan, gaji;
    
    private String Hasil(){
        return ((gaji)+(tunjangan));
    }
    
   void Kode(String Kode){
        this.kode = Kode;
    }
    void Nama(String Nama){
        this.nama = Nama;
    }
    void Tunjangan(String tunjangan){
        this.tunjangan = tunjangan;
    }
    void Gaji(String Gaji){
        this.gaji = Gaji;
    }
    
    String getKode(){
        return kode;
    }
    String getNama(){
        return nama;
    }
    String getTunjangan(){
        return tunjangan;
    }
    String getGaji(){
        return gaji;
    } 
}
          
  