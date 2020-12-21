/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class data_gaji7 extends Polimorfisme_Karyawan {
    public void biodata(String namaManager, String jabatan, double gaji, double tunjangan, double gajiakhir){
        this.nama = namaManager;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.tunjangan = tunjangan;
        this.gajiakhir = gajiakhir;
    }
    
        public String nama(){
        String nama = "Fatimah";
        System.out.println("Nama :" +nama);
        return nama;
    }
}
