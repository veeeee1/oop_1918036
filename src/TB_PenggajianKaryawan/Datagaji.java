/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Datagaji extends Abstract_Karyawan {
    public void biodata(String namamanager, String jabatan, int gaji, int tunjangan, int gajiakhir){
        this.nama = namamanager;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.tunjangan = tunjangan;
        this.total = total;
    }
    
    @Override
    public String namamanager(){
        String nama = "Fatimah Rodyahwati";
        System.out.println("Nama    :" +nama);
        return nama;
    }
    
    @Override
    public String namasupervisor(){
        String nama = "Alang Setya Pratama";
        System.out.println("Nama    :" +nama);
        return nama;
    }
    
    @Override
    public String jabatanmanager(){
        String jabatanmanager = "Manager";
        System.out.println("Jabatan    :" +jabatanmanager);
        return jabatanmanager;
    }
    
    @Override
    public String jabatansupervisor(){
        String jabatansupervisor = "Super Visor";
        System.out.println("Jabatan    :" +jabatansupervisor);
        return jabatansupervisor;
    }
    
    @Override
    int gajimanager(){
        int m = 5000000;
        System.out.println("Gaji Manager    :" +m);
        return m;
    }
    
    @Override
    int gajisupervisor(){
        int s = 3000000;
        System.out.println("Gaji Supervisor    :" +s);
        return s;
    }
    
    @Override
    int tunjanganmanager(){
        int mj = 500000;
        System.out.println("Tunjangan Manager   :" +mj);
        return mj;
    }
    
    @Override
    int tunjangansupervisor(){
        int sv = 200000;
        System.out.println("Tunjangan Super Visor   :" +sv);
        return sv;
    }
    
    @Override
    int totalmanager(){
        int mg = (gajimanager()+ tunjanganmanager());
        System.out.println("Gaji Akhir Manager :" +mg);
        return mg;
    }
    
    @Override
    int totalsupervisor(){
        int sp = (gajisupervisor()+ tunjangansupervisor());
        System.out.println("Gaji Akhir Super Visor :" +sp);
        return sp;
    }
}
    
 //   void nama(String nama, String jabatan){
  //      this.nama = nama;
  //      this.jabatan = jabatan;
//    }

 //   @Override
 //   public int gajisupervisor() {
 //     return 3000000;
 //   }

 //   @Override
 //   public int gajimanager() {
 //       return 5000000;
 //   }

  //  @Override
  //  public int tunjangansupervisor() {
  //      return 500000;
  //  }

 //   @Override
 //   public int tunjanganmanager() {
 //     return 1000000;
 //   }
//
//    @Override
 //   public int totalgajisupervisor() {
//       return (3000000 + 500000);
 //   }
    
 //   @Override
 //   public int totalgajimanager(){
 //       return (5000000 + 1000000);
 //   }
//}
