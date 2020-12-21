/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Datagaji_Exception {
    public static void main(String[]args){
        String nama,jabatan;
        double tunjangan, gaji, gajiakhir;
        
        Scanner scan = new Scanner(System.in);
        
        try{
           System.out.print("Nama       : ");
           nama = scan.nextLine();
           System.out.print("Jabatan    : ");
           jabatan = scan.nextLine();
           System.out.print("Tunjangan  : ");
           tunjangan = scan.nextInt();
           System.out.print("Gaji       : ");
           gaji = scan.nextInt();
           
           System.out.print("====================================\n");
           System.out.print("Nama       : " +nama);
           System.out.print("\nJabatam    : " +jabatan);
           System.out.print("\nTunjangan  : " +tunjangan);
           System.out.print("\nGaji       : " +gaji);
           System.out.print("\nGaji Akhir : " + (gaji +tunjangan));
        }
        catch(Exception Fatimah){
              JOptionPane.showMessageDialog(null, "Terjadi Kesalahan saat Memasukkan Data!!", "Warning",2);
        }
        finally{
         System.out.println("\nSELAMAT MENDAPATKAN GAJI");
        }
        }
        
    }
   
