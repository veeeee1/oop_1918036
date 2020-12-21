/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Penilaian;

/**
 *
 * @author ASUS
 */
public abstract class Penilaian {
    String NIM, kode_mk;
 int nilaiTugas, nilaiPrak;

 private double nilaiAkhirPrak(){
 return ((nilaiTugas*0.6)+(nilaiPrak*0.4));
 }

 double tampilNA(){
 return nilaiAkhirPrak();
 }
 abstract double nilaiAkhir();


}
    
 //   String NIM, kode_mk;
 //   public int nilaiTugas, nilaiPrak;

  //  public double nilaiAkhirPrak(){
   //     return ((nilaiTugas*0.6)+(nilaiPrak*0.4));
   // }

  //  double tampilNA(){
  //      return nilaiAkhirPrak();
   // }

  //  public int getNilaiTugas() {
   //     return nilaiTugas;
   // }

 //   public void setNilaiTugas(int nilaiTugas) {
  //      this.nilaiTugas = nilaiTugas;
  // }

  //  public int getNilaiPrak() {
     //   return nilaiPrak;
   // }

   // public void setNilaiPrak(int nilaiPrak) {
   //     this.nilaiPrak = nilaiPrak;
   // }
