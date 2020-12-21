/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_PenggajianKaryawan;
import TB_PenggajianKaryawan.GUI_Karyawan;
import TB_PenggajianKaryawan.GUI_Penggajiann;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class GUI_GajiAkhir extends javax.swing.JFrame {
    String id1, gaji1, tjgn1, ga1;
    /**
     * Creates new form GUI_GajiAkhir
     */
    public GUI_GajiAkhir() {
        initComponents();
        tampil_id();
        tampil();
    }
    
   public Connection conn;
    
    public void batal(){
        txtId.setSelectedItem("ID KARYAWAN");
        txtGaji.setText("");
        txtTjgn.setText("");
        txtGA.setText("");
    }
    
    public void koneksi()throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection
            ("jdbc:mysql://localhost/penggajian?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_GajiAkhir.class.getName())
                    .log(Level.SEVERE,null,ex);
        }
        catch (SQLException e) {
            Logger.getLogger(GUI_GajiAkhir.class.getName())
                    .log(Level.SEVERE,null,e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_GajiAkhir.class.getName())
                    .log(Level.SEVERE,null,es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID");
        tabelhead.addColumn("GAJI");
        tabelhead.addColumn("TJGN");
        tabelhead.addColumn("GA");

        try {
            koneksi();
            String sql = "SELECT * FROM tb_gajiakhir";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
        while(res.next()){
            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2)
                    ,res.getString(3),res.getString(4),});
        }
            tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
}
    
    public void refresh(){
        new GUI_GajiAkhir().setVisible(true);
        this.setVisible(false);
}
    
    public void insert(){
    String ID = (String) txtId.getSelectedItem();
    String GAJI = txtGaji.getText();
    String TJGN = txtTjgn.getText();
    String GA = txtGA.getText();

    try {
        koneksi();
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO tb_gajiakhir (id,gaji,tunjangan,gajiakhir)"
            +"VALUES('"+ID+"','"+GAJI+"','"+TJGN+"','"+GA+"')");
        statement.close();
        JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Gaji!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi KesalahanInput!");
    }
    refresh();
}
    
    public void update(){
        String ID = (String) txtId.getSelectedItem();
        String GAJI = txtGaji.getText();
           String TJGN = txtTjgn.getText();
        String GA = txtGA.getText();

        String id_lama = id1;
    

 try {
 Statement statement = conn.createStatement();
 statement.executeUpdate("UPDATE tb_gajiakhir SETid='"+ID+"'," + "gaji='"+GAJI+"'" +",tunjangan='"+TJGN+"',gajiakhir='"+GA+"' WHERE id ='"+id_lama+"'");
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
 String sql="DELETE FROM tb_gajiakhir WHERE id='"+txtId.getSelectedItem()+"''";
 PreparedStatement stmt = conn.prepareStatement(sql);
 stmt.executeUpdate();
 JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
 batal();
 }catch(Exception e){
 JOptionPane.showMessageDialog(null,"Data gagal dihapus");
 }
 }
 refresh();
}

    public void cari(){
 try{
 try (Statement statement = conn.createStatement()) {
 String sql="SELECT * FROM tb_gajiakhir WHERE `id` LIKE'%"+txtCari.getText()+"%'";
 ResultSet rs = statement.executeQuery(sql);
//menampilkan data dari sql query
 if(rs.next()) // .next() = scanner method
 {
 txtId.setSelectedItem(rs.getString(1));
 txtGaji.setText(rs.getString(2));
 txtTjgn.setText(rs.getString(3));
 txtGA.setText(rs.getString(4));
 }
 else{
 JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
 }
 }
 }catch (Exception ex){
 System.out.println("Error."+ex);
 }
}
    
        void itempilih(){
        txtId.setSelectedItem(id1);
        txtGaji.setText(gaji1);
        txtTjgn.setText(tjgn1);
        txtGA.setText(ga1);
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

        txtGA = new javax.swing.JTextField();
        txtCari = new javax.swing.JTextField();
        txtId = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnID = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNA = new javax.swing.JButton();
        txtGaji = new javax.swing.JTextField();
        txtTjgn = new javax.swing.JTextField();
        cek_tjgn = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGAActionPerformed(evt);
            }
        });

        txtId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID KARYAWAN" }));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnID.setText("ID");
        btnID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PROGRAM INPUT GAJI AKHIR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Gaji");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tunjangan");

        btnNA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNA.setText("Proses");
        btnNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNAActionPerformed(evt);
            }
        });

        cek_tjgn.setText("Tunjangan");
        cek_tjgn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_tjgnActionPerformed(evt);
            }
        });

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "GAJI", "TJGN", "GA"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

        jLabel6.setText("Gaji Akhir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCari))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(199, 199, 199)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(cek_tjgn))
                                            .addComponent(btnNA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtGA, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtTjgn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(btnUbah)
                                .addGap(67, 67, 67)
                                .addComponent(btnHapus)
                                .addGap(52, 52, 52)
                                .addComponent(btnBatal)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addGap(22, 22, 22)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnID)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cek_tjgn)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTjgn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnNA)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGAActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDActionPerformed
        // TODO add your handling code here:
       // new GUI_Matkul().setVisible(true);
    }//GEN-LAST:event_btnIDActionPerformed

    private void btnNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNAActionPerformed
        // TODO add your handling code here:
        Tunjangan nilai; // instansiasi
        //objek nilai di instansiasi ulang dengan sub class
        nilai = new Non_Tunjangan();

        if (cek_tjgn.isSelected()){
            nilai.gaji = Integer.parseInt(txtGaji.getText());
            nilai.tunjangan = Integer.parseInt(txtTjgn.getText());
            txtGA.setText(Double.toString(nilai.tampilGA()));

        }else {
            nilai.gaji = Integer.parseInt(txtGaji.getText());
            txtTjgn.setText("0");
            txtGA.setText(Double.toString(nilai.nilaiGaji()));
        }

        //     memoNilai.setText("");
        //     Penilaian nilai; // instansiasi

        //objek nilai dari super class diinisiaalisasi dengan sub class
        //     nilai = new Penilaian_NonPrak() {};

        //     nilai.NIM = txtNIM.getText();
        //     nilai.kode_mk = txtKodeMK.getText();

        //     if (cek_prak.isSelected()){
            //     nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
            //     nilai.nilaiPrak = Integer.parseInt(txtNP.getText());
            //     memoNilai.append("Nilai Akhir Mata Kuliah \n");
            //     memoNilai.append("--------------------------------------\n");
            //     memoNilai.append("NIM               : "+nilai.NIM +"\n");
            //     memoNilai.append("Kode MK           : "+nilai.kode_mk +"\n");
            //     memoNilai.append("Nilai Tugas       : "+nilai.nilaiTugas +"\n");
            //     memoNilai.append("Nilai Praktikum   : "+nilai.nilaiPrak+"\n");
            //     memoNilai.append("--------------------------------------\n");
            //     memoNilai.append("Nilai Akhir : "+nilai.tampilNA());
            //     }
        //     else {
            //     nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
            //     memoNilai.append("Nilai Akhir Mata Kuliah \n");
            //     memoNilai.append("--------------------------------------\n");
            //     memoNilai.append("NIM           : "+nilai.NIM +"\n");
            //     memoNilai.append("Kode MK       : "+nilai.kode_mk +"\n");
            //     memoNilai.append("Nilai Tugas   : "+nilai.nilaiTugas +"\n");
            //     memoNilai.append("--------------------------------------\n");
            //     memoNilai.append("Nilai Akhir   : "+nilai.nilaiAkhir());

            //       memoNilai.setText("");
            //       Penilaian_NonPrak nilai = new Penilaian_NonPrak();
            //       nilai.NIM = txtNIM.getText();
            //       nilai.kode_mk = txtKodeMK.getText();
            //       nilai.nilaiTugas = Integer.parseInt(txtNT.getText());

            //       if (cek_prak.isSelected()){
                //           nilai.nilaiPrak = Integer.parseInt(txtNP.getText());
                //           memoNilai.append("Nilai Akhir Mata Kuliah \n");
                //           memoNilai.append("--------------------------------------\n");
                //           memoNilai.append("NIM : "+nilai.NIM +"\n");
                //           memoNilai.append("Kode MK : "+nilai.kode_mk +"\n");
                //           memoNilai.append("Nilai Tugas : "+nilai.nilaiTugas +"\n");
                //           memoNilai.append("Nilai Praktikum : "+nilai.nilaiPrak +"\n");
                //           memoNilai.append("--------------------------------------\n");
                //           memoNilai.append("Nilai Akhir : "+nilai.tampilNA());

                //        }else{
                //             memoNilai.append("Nilai Akhir Mata Kuliah \n");
                //             memoNilai.append("--------------------------------------\n");
                //             memoNilai.append("NIM : "+nilai.NIM +"\n");
                //            memoNilai.append("Kode MK : "+nilai.kode_mk +"\n");
                //             memoNilai.append("Nilai Tugas : "+nilai.nilaiTugas +"\n");
                //             memoNilai.append("--------------------------------------\n");
                //             memoNilai.append("Nilai Akhir : "+nilai.tampilNA());
                //        }
    }//GEN-LAST:event_btnNAActionPerformed

    private void cek_tjgnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_tjgnActionPerformed
        // TODO add your handling code here:
        if (cek_tjgn.isSelected()){
            txtTjgn.setEnabled(true);
        }
        else{
            txtTjgn.setEnabled(false);
        }
    }//GEN-LAST:event_cek_tjgnActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel =  tabel_data.getSelectedRow(); //0
        id1 = tabel_data.getValueAt(tabel, 0).toString();
        gaji1 = tabel_data.getValueAt(tabel, 1).toString();
        tjgn1 = tabel_data.getValueAt(tabel, 2).toString();
        ga1 = tabel_data.getValueAt(tabel, 3).toString();
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
            java.util.logging.Logger.getLogger(GUI_GajiAkhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiAkhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiAkhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiAkhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_GajiAkhir().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnID;
    private javax.swing.JButton btnNA;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JCheckBox cek_tjgn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtGA;
    private javax.swing.JTextField txtGaji;
    private javax.swing.JComboBox txtId;
    private javax.swing.JTextField txtTjgn;
    // End of variables declaration//GEN-END:variables
}
