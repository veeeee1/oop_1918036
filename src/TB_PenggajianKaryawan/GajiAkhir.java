/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

/**
 *
 * @author ASUS
 */
public abstract class GajiAkhir extends Penggajian {
    
    @Override
    double gajiAkhir(){
        return (((gaji)+(tunjangan)));
   }

}
