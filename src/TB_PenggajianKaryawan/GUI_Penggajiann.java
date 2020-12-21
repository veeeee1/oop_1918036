/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class GUI_Penggajiann extends javax.swing.JFrame {
    String id1, nama1, jbtn1,gaji1;

    /**
     * Creates new form GUI_Penggajiann
     */
    public GUI_Penggajiann() {
        initComponents();
        tampil_id();
        tampil();
    }
    
  //  String id1, nama1, jbtn1, gaji1;
    
    public Connection conn;
    
        public void batal(){
            txtId.setSelectedItem("Nama Karyawan");
            txtNama.setText("");
            txtJbtn.setText("");
            txtGaji.setText("");
  //          txtTjgn.setText("");
  //          txtGA.setText("");
        }
    
        public void koneksi()throws SQLException {
            try {
                conn=null;
                Class.forName("com.mysql.jdbc.Driver");
                conn= DriverManager.getConnection("jdbc:mysql://localhost/penggajian?user=root&password=");
            }
            catch (ClassNotFoundException ex){
                Logger.getLogger(GUI_Penggajiann.class.getName()).log(Level.SEVERE,null,ex);
            }
            catch (SQLException e) {
                Logger.getLogger(GUI_Penggajiann.class.getName()).log(Level.SEVERE,null,e);
            }
            catch (Exception es) {
                Logger.getLogger(GUI_Penggajiann.class.getName()).log(Level.SEVERE,null,es);
            }
        }
        
        public void tampil() {
            DefaultTableModel tabelhead = new DefaultTableModel();
            tabelhead.addColumn("NAMA");
            tabelhead.addColumn("KODE KARYAWAN");
            tabelhead.addColumn("JABATAN");
            tabelhead.addColumn("GAJI");
    //        tabelhead.addColumn("TUNJANGAN");
   //          tabelhead.addColumn("GAJI AKHIR");

        try {
            koneksi();
            String sql = "SELECT * FROM tb_penggajian";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
        while(res.next()){
            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),});
        }
            tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
        
        public void refresh(){
            new GUI_Penggajiann().setVisible(true);
            this.setVisible(false);
        }
            
        public void insert(){
            String ID = (String) txtId.getSelectedItem();
            String NAMA = txtNama.getText();
            String JABATAN = txtJbtn.getText();
            String GAJI = txtGaji.getText();
 //           String TUNJANGAN = txtTjgn.getText();
  //          String GAJIAKHIR = txtGA.getText();
    

        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_penggajian (id,nama,jabatan,gaji)"
                                    +"VALUES('"+ID+"','"+NAMA+"','"+JABATAN+"','"+GAJI+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Gaji!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi KesalahanInput!");
        }
        refresh();
    }
            
        public void update(){
            String ID = (String) txtId.getSelectedItem();
            String NAMA = txtNama.getText();
            String JABATAN = txtJbtn.getText();
            String GAJI = txtGaji.getText();
     //       String TUNJANGAN = txtTjgn.getText();
       //     String GAJIAKHIR = txtGA.getText();

            String id_lama = id1;
       //     String kode = kd1;
       //     String jabatan = jbtn1;
            

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_penggajian SET id='"+ID+"'," + "nama='"+NAMA+"'" +",jabatan='"+JABATAN+"',gaji='"
                                        +GAJI+"' WHERE id ='"+id_lama+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Gaji!");
        } catch (Exception e) {
            System.out.println("Error : "+e);
    }
        refresh();
    }   
    
      public void delete(){
      int ok =JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
      if(ok==0){
        try{
            String sql="DELETE FROM tb_penggajian WHERE id='"+txtId.getSelectedItem()+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            batal();
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Data gagal di hapus");
        }
    }
        refresh();
    }
      
      public void cari(){
        try{
            try (Statement statement = conn.createStatement()) {
                String sql="SELECT * FROM tb_penggajian WHERE `nama` LIKE'%"+txtCari.getText()+"%'";
                ResultSet rs = statement.executeQuery(sql);
//menampilkan data dari sql query
        if(rs.next()) // .next() = scanner method
        {
            txtId.setSelectedItem(rs.getString(1));
            txtNama.setText(rs.getString(2));
            txtJbtn.setText(rs.getString(3));
            txtGaji.setText(rs.getString(4));
//            txtTjgn.setText(rs.getString(5));
//            txtGA.setText(rs.getString(6));
        }
        else{
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
        }
    }
        }catch (Exception ex){
            System.out.println("Error."+ex);
        }
    }
    
  //      public void tampil_nama(){
  //      try {
   //         koneksi();
   //         String sql = "SELECT ID_Karyawan FROM tb_penggajian order by ID_Karyawan asc";  
   //         Statement stt = conn.createStatement();
   //         ResultSet res = stt.executeQuery(sql);              
   //         while(res.next()){
    //           Object[] ob = new Object[3];
    //           ob[0] = res.getString(1);

    //           txtId.addItem((String)ob[0]);  
    //        }

     //       res.close(); 
     //       stt.close();
      //  } catch (Exception e) {
      //         System.out.println(e.getMessage());
       // }
  //  }
        
    void itempilih(){
        txtId.setSelectedItem(id1);
        txtNama.setText(nama1);
        txtJbtn.setText(jbtn1);
        txtGaji.setText(gaji1);
//        txtTjgn.setText(tjgn1);
//        txtGA.setText(ga1);
    }
    
    
    public void tampil_id(){
 try {
 koneksi();
 String sql = "SELECT ID_Karyawan FROM tb_karyawan order by ID_Karyawan asc";
 Statement stt = conn.createStatement();
 ResultSet res = stt.executeQuery(sql);
 while(res.next()){
 Object[] ob = new Object[3];
 ob[0] = res.getString(1);
 txtId.addItem(ob[0]);
 }
 res.close();
 stt.close();
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
}
          
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtGaji = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        txtJbtn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("INPUT GAJI KARYAWAN");

        txtId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID KARYAWAN" }));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel2.setText("GAJI");

        btnProses.setText("PROSES");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "GAJI"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_data);

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        jLabel5.setText("NAMA");

        jLabel6.setText("JABATAN");

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJbtn)
                                    .addComponent(txtGaji))))))
                .addContainerGap(547, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCari)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUbah)
                                .addGap(44, 44, 44)
                                .addComponent(btnHapus)
                                .addGap(51, 51, 51)
                                .addComponent(btnBatal)
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBatal)
                            .addComponent(btnHapus)
                            .addComponent(btnUbah)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtJbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(btnProses)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        int tabel = tabel_data.getSelectedRow();
        id1 = tabel_data.getValueAt(tabel, 0).toString();
        nama1 = tabel_data.getValueAt(tabel, 1).toString();
        jbtn1 = tabel_data.getValueAt(tabel, 2).toString();
        gaji1 = tabel_data.getValueAt(tabel, 3).toString();
   //     tjgn1 = tabel_data.getValueAt(tabel, 5).toString();
   //     ga1 = tabel_data.getValueAt(tabel, 6).toString();
        itempilih();
    }//GEN-LAST:event_tabel_dataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Penggajiann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Penggajiann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Penggajiann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Penggajiann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Penggajiann().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtGaji;
    private javax.swing.JComboBox txtId;
    private javax.swing.JTextField txtJbtn;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
