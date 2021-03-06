/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parapuan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.parapuan.model.Concatter;
import com.mycompany.parapuan.model.Musteri;
import com.mycompany.parapuan.model.Odeme;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author spring
 */
public class Raporlar extends javax.swing.JFrame {

    /**
     * Creates new form Raporlar
     */
    public Raporlar() {
        initComponents();
        setgunlukvalues();
        setaylıkvalues();
        settoplamvalues();
        setbenimpayim();
        setmustelerinAlacagı();
        setuyesayisi();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
        dagitimorani.setText(String.valueOf(Constants.birim));
    }
    private void setgunlukvalues () {
        try {
            PreparedStatement st = connection.prepareStatement("select sum(tutar)as toplam ,count(tutar) as tane from odemeler where tarih =? ");
            st.setDate(1, new Date(System.currentTimeMillis()));
            ResultSet executeQuery = st.executeQuery();
            if(executeQuery.next()) {
                gunlukciro.setText(String.valueOf(executeQuery.getFloat("toplam"))+"₺");
                gunlukalısverissayisi.setText( String.valueOf(executeQuery.getInt("tane")));
                
                       
            }
            executeQuery.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Date subtractDays(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -30);
        return new Date(c.getTimeInMillis());
    }
    private void setaylıkvalues () {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("select sum(tutar)as toplam ,count(tutar) as tane from odemeler where tarih >?");
            Date date = new Date(System.currentTimeMillis());
            Date subtractDays = subtractDays(new Date(System.currentTimeMillis()));
            System.out.println(subtractDays);
            prepareStatement.setDate(1, subtractDays);
            ResultSet executeQuery = prepareStatement.executeQuery();
            if(executeQuery.next()) {
                aylıkciro.setText(String.valueOf(executeQuery.getFloat("toplam")) + "₺");
                aylıkalısverissayisi.setText(String.valueOf(executeQuery.getInt("tane")));
            }
            executeQuery.close();
            prepareStatement.close();
                   
        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void settoplamvalues () {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("select sum(tutar)as toplam ,count(tutar) as tane from odemeler");
         
            ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                toplamciro.setText(String.valueOf(executeQuery.getFloat("toplam")) + "₺");
                toplamalisveris.setText(String.valueOf(executeQuery.getInt("tane")));
            }
            executeQuery.close();
            prepareStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    Connection connection = Veritabani.getConnection();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gunlukciro = new javax.swing.JLabel();
        gunlukalısverissayisi = new javax.swing.JLabel();
        aylıkciro = new javax.swing.JLabel();
        aylıkalısverissayisi = new javax.swing.JLabel();
        toplamalisveris = new javax.swing.JLabel();
        toplamciro = new javax.swing.JLabel();
        musterialacagi = new javax.swing.JLabel();
        benimpayim = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dagitimorani = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        yenibirim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        uyesayisi = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Raporlar");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setText("Günlük Ciro :");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel3.setText("Günlük Alışveriş Sayısı :");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel4.setText("Aylık Ciro :");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel5.setText("Aylık Alışveriş Sayısı :");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel6.setText("Toplam Alışveriş Sayısı :");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel7.setText("Toplam Ciro : ");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel8.setText("Müşterilerin Alacağı");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel9.setText("Benim Payım  : ");

        gunlukciro.setText("jLabel10");

        gunlukalısverissayisi.setText("jLabel10");

        aylıkciro.setText("jLabel10");

        aylıkalısverissayisi.setText("jLabel10");

        toplamalisveris.setText("jLabel10");

        toplamciro.setText("jLabel10");

        musterialacagi.setText("jLabel10");

        benimpayim.setText("jLabel10");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel10.setText("Dağıtım Oranı :");

        dagitimorani.setText("jLabel11");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel11.setText("Dağıtım Güncelle :");

        jButton1.setText("GÜNCELLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("YEDEKLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel12.setText("Üye Sayısı :");

        jButton3.setText("TELEFON ÇIKTISI AL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toplamalisveris)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(benimpayim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(musterialacagi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aylıkalısverissayisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aylıkciro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gunlukalısverissayisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gunlukciro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toplamciro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dagitimorani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(yenibirim)
                                .addComponent(uyesayisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(gunlukciro))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(gunlukalısverissayisi))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(aylıkciro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(aylıkalısverissayisi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(toplamciro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(toplamalisveris))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(musterialacagi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(benimpayim))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dagitimorani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(yenibirim, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(uyesayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<Musteri> musteriler=new ArrayList();
        List<Odeme> odemeler=new ArrayList();
        try {

            Statement prepareStatement = connection.createStatement();
            ResultSet rs = prepareStatement.executeQuery("select * from musteri");

            while(rs.next()) {

                Musteri musteri = new Musteri();
                musteri.setId(rs.getInt("id"));
                musteri.setName(rs.getString("name"));
                musteri.setNumara(rs.getString("numara"));
                musteri.setParapuan(rs.getFloat("parapuan"));
                musteri.setReferansno(rs.getInt("referansno"));
                musteri.setReferansolan(rs.getInt("referansolan"));
                musteriler.add(musteri);

            }
            prepareStatement.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            Statement prepareStatement = connection.createStatement();
            ResultSet rs = prepareStatement.executeQuery("select * from odemeler");

            while(rs.next()) {

                Odeme odeme = new Odeme();
                odeme.setTarih(rs.getDate("tarih"));
                odeme.setTutar(rs.getFloat("tutar"));
                odeme.setTelno(rs.getString("telno"));
                odemeler.add(odeme);

            }
            prepareStatement.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }

        Concatter concatter = new Concatter();
        concatter.setMusteri(musteriler);
        concatter.setOdeme(odemeler);

        ObjectMapper mapper = new ObjectMapper();
        String json=null;
        try {
            json = mapper.writeValueAsString(concatter);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Path of = Path.of("C:\\yedekler\\yedek-"+new Date(System.currentTimeMillis()).toString()+".json");
        Path of1 = Path.of("D:\\yedekler\\yedek-"+new Date(System.currentTimeMillis()).toString()+".json");
        try {
            Files.deleteIfExists(of);
            Files.deleteIfExists(of1);
        } catch (IOException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Path createFile = Files.createFile(of);
            Files.write(createFile,json.getBytes());
            
            Path createFile1 = Files.createFile(of1);
            Files.write(createFile1,json.getBytes());

        } catch (IOException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            float parseFloat = Float.parseFloat(this.yenibirim.getText());
            PreparedStatement prepareStatement = connection.prepareStatement("update birims set birim=?");
            prepareStatement.setFloat(1, parseFloat);
            prepareStatement.execute();
            prepareStatement.close();
            Constants.birim=parseFloat;
            dagitimorani.setText(String.valueOf(parseFloat));
            prepareStatement.close();
        }catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Path of = Path.of("C:\\yedekler\\numaralar-"+new Date(System.currentTimeMillis()).toString()+".txt");
            try {
                Files.deleteIfExists(of);
                Files.createFile(of);
            } catch (IOException ex) {
                Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try {
                StringBuilder builder=new StringBuilder();
             PreparedStatement prepareStatement = connection.prepareStatement("select numara from musteri");
            ResultSet executeQuery = prepareStatement.executeQuery();
            
            while(executeQuery.next()){
               
                String string = executeQuery.getString(1);
                 builder.append(string+"\n");
                 
            }
            try {
                    Files.writeString(of, builder);
                 } catch (IOException ex) {
                     Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 prepareStatement.close();
                 executeQuery.close();
        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Raporlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aylıkalısverissayisi;
    private javax.swing.JLabel aylıkciro;
    private javax.swing.JLabel benimpayim;
    private javax.swing.JLabel dagitimorani;
    private javax.swing.JLabel gunlukalısverissayisi;
    private javax.swing.JLabel gunlukciro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel musterialacagi;
    private javax.swing.JLabel toplamalisveris;
    private javax.swing.JLabel toplamciro;
    private javax.swing.JLabel uyesayisi;
    private javax.swing.JTextField yenibirim;
    // End of variables declaration//GEN-END:variables

    private void setbenimpayim() {
        try {
            PreparedStatement st = connection.prepareStatement("select parapuan from musteri where referansno=1111111111 ");
            
            ResultSet executeQuery = st.executeQuery();
            if(executeQuery.next()) {
                benimpayim.setText(String.valueOf(executeQuery.getFloat("parapuan"))+"₺");
 }
            executeQuery.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setmustelerinAlacagı() {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("select sum(parapuan)as toplam  from musteri");
         
            ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                musterialacagi.setText(String.valueOf(executeQuery.getFloat("toplam")) + "₺");
                
            }
            executeQuery.close();
            prepareStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setuyesayisi() {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT COUNT(*) as sayi FROM musteri;");
         
            ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                uyesayisi.setText(String.valueOf(executeQuery.getInt("sayi")));
                
            }
            executeQuery.close();
            prepareStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
