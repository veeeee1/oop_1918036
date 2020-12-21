/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB5.Overload_Override;

/**
 *
 * @author ASUS
 */
public class MainOverload_Override {
    
    public static void main(String[] args) {
    Method_Override n = new Method_Override();
    System.out.println("Luas Parameter Double : "+ n.Luas(4.6));
    System.out.println("Luas Parameter Integer :"+ n.Luas(6));
    System.out.println("Jumlah :"+ n.Jumlah(6.5, 9));

    //override
    System.out.println("Volume Kubus : "+ n.Volume());
 }

}
