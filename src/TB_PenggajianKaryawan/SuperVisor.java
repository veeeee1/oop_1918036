/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public class SuperVisor implements Gaji {

    @Override
    public double gaji() {
        return 3000000;
    }

    @Override
    public double tunjangan() {
        return 500000;
    }

    @Override
    public double gajiakhir() {
        return gaji() + tunjangan();
    }
}
