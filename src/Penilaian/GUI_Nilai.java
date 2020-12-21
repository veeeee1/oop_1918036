/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Penilaian;
import penilaian.GUI_Mahasiswa;
import Penilaian.GUI_Matkul;
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
public class GUI_Nilai extends javax.swing.JFrame {
    String nim1, kd_mk1, n1,n2,n3;

    /**
     * Creates new form GUI_Nilai
     */
    public GUI_Nilai() {
        initComponents();
      txtNP.setEnabled(false);
        tampil();
       // refresh();
        tampil_mhs();
        tampil_mk();
        
    } 
    
    public Connection conn;
    
    public void batal(){
        txtNIM.setSelectedItem("--NIM--");
        txtKodeMK.setSelectedItem("--Kode MK--");
        txtNT.setText("");
        txtNP.setText("");
        txtNA.setText("");
    }
    
    public void koneksi()throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection
            ("jdbc:mysql://localhost/oop_1918036?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_Nilai.class.getName())
                    .log(Level.SEVERE,null,ex);
        }
        catch (SQLException e) {
            Logger.getLogger(GUI_Nilai.class.getName())
                    .log(Level.SEVERE,null,e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_Nilai.class.getName())
                    .log(Level.SEVERE,null,es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("NIM");
        tabelhead.addColumn("Kode MK");
        tabelhead.addColumn("NT");
        tabelhead.addColumn("NP");
        tabelhead.addColumn("NA");

        try {
            koneksi();
            String sql = "SELECT * FROM tb_nilai";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
        while(res.next()){
            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2)
                    ,res.getString(3),res.getString(4), res.getString(5),});
        }
            tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
}
    
    public void refresh(){
        new GUI_Nilai().setVisible(true);
        this.setVisible(false);
}
    
    public void insert(){
    String NIM = (String) txtNIM.getSelectedItem();
    String KodeMK = (String) txtKodeMK.getSelectedItem();
    String NT = txtNT.getText();
    String NP = txtNP.getText();
    String NA = txtNA.getText();

    try {
        koneksi();
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO tb_nilai (nim,kode_mk, n_tugas,n_prak,n_akhir)"
            +"VALUES('"+NIM+"','"+KodeMK+"','"+NT+"','"+NP+"','"+NA+"')");
        statement.close();
        JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Nilai!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi KesalahanInput!");
    }
    refresh();
}
    
    public void update(){
        String NIM = (String) txtNIM.getSelectedItem();
        String KodeMK = (String) txtKodeMK.getSelectedItem();
        String NT = txtNT.getText();
           String NP = txtNP.getText();
        String NA = txtNA.getText();

        String nim_lama = nim1;
        String kode_lama = kd_mk1;

 try {
 Statement statement = conn.createStatement();
 statement.executeUpdate("UPDATE tb_nilai SETnim='"+NIM+"'," + "kode_mk='"+KodeMK+"'" +",n_tugas='"+NT+"',n_prak='"+NP+"',n_akhir='"
         +NA+"' WHERE nim ='"+nim_lama+"' AND kode_mk='"+kode_lama+"'");
 statement.close();
 conn.close();
 JOptionPane.showMessageDialog(null, "Update Data Matakuliah!");
 } catch (Exception e) {
 System.out.println("Error : "+e);
 }
 refresh();
}
    
    public void delete(){
 int ok =JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
 if(ok==0){
 try{
 String sql="DELETE FROM tb_nilai WHERE nim='"+txtNIM.getSelectedItem()+"' AND kode_mk='"+txtKodeMK.getSelectedItem()+"'";
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
 String sql="SELECT * FROM tb_nilai WHERE `nim` LIKE'%"+txtCari.getText()+"%'";
 ResultSet rs = statement.executeQuery(sql);
//menampilkan data dari sql query
 if(rs.next()) // .next() = scanner method
 {
 txtNIM.setSelectedItem(rs.getString(1));
 txtKodeMK.setSelectedItem(rs.getString(2));
 txtNT.setText(rs.getString(3));
 txtNP.setText(rs.getString(4));
 txtNA.setText(rs.getString(5));
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
        txtNIM.setSelectedItem(nim1);
        txtKodeMK.setSelectedItem(kd_mk1);
        txtNT.setText(n1);
        txtNP.setText(n2);
        txtNA.setText(n3);
    }
    
    public void tampil_mhs(){
 try {
 koneksi();
 String sql = "SELECT nim FROM tb_mahasiswa order by nim asc";
 Statement stt = conn.createStatement();
 ResultSet res = stt.executeQuery(sql);
 while(res.next()){
 Object[] ob = new Object[3];
 ob[0] = res.getString(1);
 txtNIM.addItem(ob[0]);
 }
 res.close();
 stt.close();
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
}
 
    public void tampil_mk(){
 try {
 koneksi();
 String sql = "SELECT kode_mk FROM tb_matkul order by kode_mk asc";
 Statement stt = conn.createStatement();
 ResultSet res = stt.executeQuery(sql);
 while(res.next()){
 Object[] ob = new Object[3];
 ob[0] = res.getString(1);
 txtKodeMK.addItem(ob[0]);
 }
 res.close(); stt.close();
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
}


    //    public void batal(){
    //    txtNIM.setText("");
    //    txtKodeMK.setText("");
    //    txtNT.setText("");
    //    txtNP.setText("");
    //    txtNA.setText("");
   // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNA = new javax.swing.JButton();
        txtNT = new javax.swing.JTextField();
        txtNP = new javax.swing.JTextField();
        cek_prak = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtNA = new javax.swing.JTextField();
        txtCari = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnNIM = new javax.swing.JButton();
        btnKodeMk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        txtNIM = new javax.swing.JComboBox();
        txtKodeMK = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PROGRAM PENILAIAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nilai Tugas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nilai Praktikum");

        btnNA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNA.setText("Proses");
        btnNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNAActionPerformed(evt);
            }
        });

        cek_prak.setText("Praktikum");
        cek_prak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_prakActionPerformed(evt);
            }
        });

        jLabel6.setText("Nilai Akhir");

        txtNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAActionPerformed(evt);
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

        btnNIM.setText("NIM");
        btnNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNIMActionPerformed(evt);
            }
        });

        btnKodeMk.setText("Kode MK");
        btnKodeMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKodeMkActionPerformed(evt);
            }
        });

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Kode MK", "NT", "NP", "NA"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

        txtNIM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--NIM--" }));
        txtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIMActionPerformed(evt);
            }
        });

        txtKodeMK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--KODE MK--" }));
        txtKodeMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(60, 60, 60)
                                    .addComponent(txtNA, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnNA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                    .addComponent(txtNP, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(52, 52, 52)
                                    .addComponent(txtNT))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnNIM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnKodeMk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtKodeMK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNIM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(50, 50, 50))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addComponent(cek_prak))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(btnUbah)
                                .addGap(67, 67, 67)
                                .addComponent(btnHapus)
                                .addGap(52, 52, 52)
                                .addComponent(btnBatal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCari)))
                .addContainerGap(78, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNIM)
                            .addComponent(txtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKodeMk)
                            .addComponent(txtKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cek_prak)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(btnNA)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNAActionPerformed
        // TODO add your handling code here:
  Penilaian nilai; // instansiasi
 //objek nilai di instansiasi ulang dengan sub class
 nilai = new Penilaian_NonPrak();

 if (cek_prak.isSelected()){
 nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
 nilai.nilaiPrak = Integer.parseInt(txtNP.getText());
 txtNA.setText(Double.toString(nilai.tampilNA()));

 }else {
 nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
 txtNP.setText("0");
 txtNA.setText(Double.toString(nilai.nilaiAkhir()));
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

    private void cek_prakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_prakActionPerformed
        // TODO add your handling code here:
        if (cek_prak.isSelected()){
            txtNP.setEnabled(true);
        }
        else{
            txtNP.setEnabled(false);
        }
    }//GEN-LAST:event_cek_prakActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel =  tabel_data.getSelectedRow(); //0
        nim1 = tabel_data.getValueAt(tabel, 0).toString();
        kd_mk1 = tabel_data.getValueAt(tabel, 1).toString();
        n1 = tabel_data.getValueAt(tabel, 2).toString();
        n2 = tabel_data.getValueAt(tabel, 3).toString();
        n3 = tabel_data.getValueAt(tabel, 4).toString();
        itempilih();
    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btnNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNIMActionPerformed
        // TODO add your handling code here:
        new GUI_Mahasiswa().setVisible(true);
    }//GEN-LAST:event_btnNIMActionPerformed

    private void txtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIMActionPerformed

    private void txtKodeMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeMKActionPerformed

    private void btnKodeMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKodeMkActionPerformed
        // TODO add your handling code here:
        new GUI_Matkul().setVisible(true);
    }//GEN-LAST:event_btnKodeMkActionPerformed

    private void txtNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNAActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Nilai().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKodeMk;
    private javax.swing.JButton btnNA;
    private javax.swing.JButton btnNIM;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JCheckBox cek_prak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txtCari;
    private javax.swing.JComboBox txtKodeMK;
    private javax.swing.JTextField txtNA;
    private javax.swing.JComboBox txtNIM;
    private javax.swing.JTextField txtNP;
    private javax.swing.JTextField txtNT;
    // End of variables declaration//GEN-END:variables
}
