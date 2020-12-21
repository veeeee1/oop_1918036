/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Penilaian;

/**
 *
 * @author ASUS
 */
public class Data_Matkul {
    
   String KodeMK, MK, SKS;
    String kode1, mk1, sks1;
    
   void KodeMK(String KodeMK){
        this.KodeMK = KodeMK;
    }
    
   void MK(String MK){
        this.MK = MK;
    }
    
   void SKS(String SKS){
        this.SKS = SKS;
    }
    
    String getKodeMK(){
       return KodeMK;
   }
    
   String getMK(){ 
       return MK;
    }
    
   String getSKS(){ 
      return SKS;
   }
}
