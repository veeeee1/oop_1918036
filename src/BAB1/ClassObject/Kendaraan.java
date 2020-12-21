/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB1.ClassObject;

/**
 *
 * @author ASUS
 */
public class Kendaraan {
    String nama, warna; //atribut
    
    public Kendaraan(String nama, String warna){
        this.nama = nama;
        this.warna = warna;
    }
    //method
    int jmlRoda(int jml){
        return jml;
    }
    
    void kendaraanMaju(){
        System.out.println("Berjalan ke depan");
    }
    
    void kendaraanMundur(){
        System.out.println("Berjalan ke belakang");
    }
    void kendaraanBerhenti(){
        System.out.println(" Berhenti");
    } 
    
}