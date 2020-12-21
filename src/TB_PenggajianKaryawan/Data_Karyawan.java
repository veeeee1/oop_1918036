/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
class Data_Karyawan {
    //String nim1,nama1,prodi1,ang1;
    String id, nama, usia, jabatan;
    
 void dataId(String Id){
 this.id = id;
 }
 void dataNama(String Nama){
 this.nama = nama;
 }
 void dataUsia(String Usia){
 this.usia = usia;
 }
 void dataJabatan(String Jabatan){
 this.jabatan = jabatan;
 }

 String cetakId(){
 return id;
 }
 String cetakNama(){
 return nama;
 }
 String cetakUsia(){
 return usia;
 }
 String cetakJabatan(){
 return jabatan;
 }

    
}
