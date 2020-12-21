/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class Manager implements Gaji {

    @Override
    public double gaji() {
        return 5000000;
    }

    @Override
    public double tunjangan() {
        return 500000;
    }

    @Override
    public double gajiakhir() {
        return gaji()+tunjangan();
    }   
}
