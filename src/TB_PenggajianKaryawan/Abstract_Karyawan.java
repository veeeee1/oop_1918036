/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public abstract class Abstract_Karyawan {
    public String nama, jabatan;
    public int gaji, tunjangan, total;
    public void biodata(String namamanager){
        this.nama = namamanager;
    }
    
    public void biodata(String namamanager,String jabatan){
        this.nama=namamanager;
        this.jabatan= jabatan;
    }
    
    public String namamanager(){
        return nama;
    }
    public String namasupervisor(){
        return nama;
    }
    public String jabatanmanager(){
        return jabatan;
    }
    public String jabatansupervisor(){
        return jabatan;
    }
    
    int gajimanager(){
        return 0;
    }
    int gajisupervisor(){
        return 0;
    }
    int tunjanganmanager(){
        return 0;
    }
    int tunjangansupervisor(){
        return 0;
    }
    int totalmanager(){
        return 0;
    }
    int totalsupervisor(){
        return 0;
    }
}
    
    
//    public abstract int gajisupervisor();
//    public abstract int gajimanager();
 //   public abstract int tunjangansupervisor();
//    public abstract int tunjanganmanager();
//    public abstract int totalgajisupervisor();
//    public abstract int totalgajimanager();
    
//    public void nama(String nama){
 //       this.nama = nama;
 //   }


