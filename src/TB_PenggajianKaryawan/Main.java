/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[]args){
        Datagaji data = new Datagaji();
        
        data.namasupervisor();
        data.jabatansupervisor();
        data.totalsupervisor();
        System.out.println("\n");
        data.namamanager();
        data.jabatanmanager();
        data.totalmanager();
    } 
}
