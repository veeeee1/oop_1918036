/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Karyawan {

    String nama, kode_krywn;
    private int gaji, tunjangan;
    
     private double gajiAkhir(){
        return ((gaji)+(tunjangan));
    }
    
    void Gaji(int gaji)
    {
        this.gaji = gaji;
    }

    void Tunjangan(int tunjangan)
    {
        this.tunjangan = tunjangan;
    }
    
    double tampilGaji(){
        return gajiAkhir();
    }
    
    void nama(String nama)
    {
        this.nama = nama;
    }
    String tampilnama(){
        return nama;
    }
    
    void kode_krywn(String kode_krywn)
    {
        this.kode_krywn = kode_krywn;
    }
    String tampilkode(){
        return kode_krywn;
    }
}

 //   String menu;
 //   public double gaji,hasil;
//    public String tunjangan;
//    public double Karyawan(){
  //      hasil = gaji + tunjangan;
 //       return Karyawan();
   