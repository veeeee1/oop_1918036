/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Class_Karyawan {
    String kode, nama;
    
    void Kode(String Kode){
        this.kode = Kode;
    }
    void Nama(String Nama){
        this.nama = Nama;
    }
    
    String getKode(){
        return kode;
    }
    String getNama(){
        return nama;
    }  

    void kode(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void nama(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
