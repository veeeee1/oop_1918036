/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Penilaian;

/**
 *
 * @author ASUS
 */
public class CrtakKTM {
    public static void main(String[] args) {
 // membuat object dengan nama “mhs” dari class Mahasiswa
 Mahasiswa mhs = new Mahasiswa();
 //ketika akan menggunakan method dari class Mahasiswa maka harus menyertakan nama object
 mhs.dataNIM("1918036");
 mhs.dataNama("FATIMAH");
 mhs.dataProdi("Teknik Informatika");
 mhs.dataAngkatan("2019");
  System.out.println("Kartu Tanda Mahasiswa ITN Malang");
 System.out.println("------------------------------------");
 System.out.println("NIM : "+ mhs.cetakNIM());
 System.out.println("Nama : "+ mhs.cetakNama());
 System.out.println("Prodi : "+ mhs.cetakProdi());
 System.out.println("Angkatan : "+ mhs.cetakAngkatan());
  }
}
