/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Polimorfisme_Karyawan {
    public String nama, jabatan;
    double gaji, tunjangan, gajiakhir;
    
    public void biodata(String namaManager){
        this.nama = namaManager;
    }
    public void biodata(String namaManager, String jabatan){
        this.nama = namaManager;
        this.jabatan = jabatan;
    }
    
    public String namaManager(){
        return nama;
    }
    public String namaSupervisor(){
        return nama;
    }
    
    public String jabatanManager(){
        return jabatan;
    }
    public String jabatanSupervisor(){
        return jabatan;
    }
    
    double gajiManager(){
        return 0;
    }
    double gajiSupervisor(){
        return 0;
    }
    
    double tunjanganManager(){
        return 0;
    }
    double tunjanganSupervisor(){
        return 0;
    }
    
    double gajiakhirManager(){
        return 0;
    }
    double gajiakhirSupervisor(){
        return 0;
    }
}
