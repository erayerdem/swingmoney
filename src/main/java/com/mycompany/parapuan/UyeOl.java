/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parapuan;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eray
 */
public class UyeOl extends javax.swing.JFrame {

    Connection connection = Veritabani.getConnection();
   
    public UyeOl() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       
        phonenumber.setForeground(Color.GRAY);
        phonenumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phonenumber.getText().equals("541 410 65 30")) {
                    phonenumber.setText("");
                    phonenumber.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phonenumber.getText().isEmpty()) {
                    phonenumber.setForeground(Color.GRAY);
                    phonenumber.setText("541 410 65 30");
                }
            }
        });
  
        sonuc.setVisible(false);
        uyeno.setVisible(false);
        
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adisoyadi = new javax.swing.JTextField();
        phonenumber = new javax.swing.JTextField();
        referans = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        sonuc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uyeno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setText("Adı Soyadı");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel2.setText("Telefon Numarası");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel3.setText("Referans veya Telelefon Numarası");

        adisoyadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adisoyadiActionPerformed(evt);
            }
        });

        phonenumber.setText("541 410 65 30");

        referans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referansActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("KAYIT OL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sonuc.setText("Sonuç");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setText("ÜYE OL");

        uyeno.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phonenumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adisoyadi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(referans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uyeno))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(0, 385, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(adisoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(sonuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uyeno)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        uyeno.setVisible(false);
        sonuc.setVisible(false);
        boolean durum=false;
        int uyenumarası =0;
        String numara = phonenumber.getText();
        String adisoyadi = this.adisoyadi.getText();
        Pattern p = Pattern.compile("^5+[0-9]{2}[0-9]{3}[0-9]{2}[0-9]{2}");
        Matcher matcher = p.matcher(numara);
        boolean numvalid = matcher.matches();
        boolean adivalid = adisoyadi.length()>5;
        String referansveyatel=referans.getText();
        Matcher si=p.matcher(referansveyatel);
        boolean matchtel=si.matches();
        boolean bosmu = referansveyatel.equals("");
        boolean mathchertwo=false;
        int value = 0;
        if (!matchtel)
        {   boolean hata=false;
            try{
                value= Integer.parseInt(referansveyatel);}
            catch (Exception ex) {
                hata=true;
            }
            if (!hata) {
                if(value>999999999 ) {

                    mathchertwo=true;
                }}
            }
            System.out.println(mathchertwo+" "+matchtel+" "+bosmu);
            if (numvalid && adivalid &&(matchtel || mathchertwo || bosmu) ) {
                System.out.println("buraya  girdi");
                LocalDateTime now = LocalDateTime.now();
                String format = String.format( "%d%d%d%d%d",
                    now.getMonthValue()+10,
                    now.getDayOfMonth()+10,
                    now.getHour()+10, now.getMinute()+10, now.getSecond()+10 );
                uyenumarası= Integer.parseInt( format );
                String yeninumara="+90"+numara;
                if(bosmu) {
                    try {
                        kaydet2(adisoyadi, yeninumara, uyenumarası);
                        durum = true;
                    } catch (SQLException ex) {
                        durum=false;
                       
                    }
                }
                else  if (mathchertwo) {
                    try {
                        PreparedStatement prepareStatement = connection.prepareStatement("select * from musteri where referansno=?");
                        prepareStatement.setInt(1, value);
                        ResultSet executeQuery = prepareStatement.executeQuery();

                        if (executeQuery.next()) {

                            kaydet(adisoyadi, yeninumara, uyenumarası, value);
                            durum = true;
                        }
                        else {
                            System.out.println("sorun burdada");
                            durum=false;}
                        prepareStatement.close();
                        executeQuery.close();
                               

                    }
                    catch (SQLException ex) {

                        durum=false;
                        
                    }
                }
                else if(matchtel) {
                    try {
                        boolean kayit=false;
                        boolean buldu=false;
                        String referansno="+90"+referansveyatel;
                        PreparedStatement createStatement = connection.prepareStatement("select referansno from musteri where numara=?");
                        createStatement.setString(1, referansno);

                        ResultSet rs = createStatement.executeQuery();
                        if(rs.next()) {
                            buldu=true;
                            int value1=rs.getInt(1);
                            try {
                                kaydet(adisoyadi, yeninumara, uyenumarası, value1);
                                kayit=true;
                            }
                            catch (Exception ex) {
                                durum=false;
                                
                            }
                        }
                        if(buldu && kayit) {
                            durum=true;
                        }
                        else  {
                            durum=false;
                        }
                            createStatement.close();
                            rs.close();
                    } catch (SQLException ex) {
                        
                        durum=false;
                    }

                }

            }
            else {
                durum = false;

            }
            hallet (durum ,uyenumarası);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void referansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_referansActionPerformed

    private void adisoyadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adisoyadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adisoyadiActionPerformed
    public void kaydet (String adisoyadi,String yeninumara,int uyenumarası,Integer value) throws SQLException {
        
        PreparedStatement createStatement = connection.prepareStatement("INSERT INTO musteri(\n"
                + "	 name, numara, referansno, referansolan)\n"
                + "	VALUES (  ?, ?, ?, ?)");

        createStatement.setString(1, adisoyadi);
        createStatement.setString(2, yeninumara);
        createStatement.setInt(3, uyenumarası);
        createStatement.setInt(4, value);
        createStatement.execute();
        createStatement.close();
        
        }
    public void kaydet2(String adisoyadi, String yeninumara, int uyenumarası) throws SQLException {
        // buraya kontroller ekle varsa veri tabanında eklemesin tabloya
        PreparedStatement createStatement = connection.prepareStatement("INSERT INTO musteri(\n"
                + "	 name, numara, referansno)\n"
                + "	VALUES (  ?, ?, ?)");

        createStatement.setString(1, adisoyadi);
        createStatement.setString(2, yeninumara);
        createStatement.setInt(3, uyenumarası);
        
        createStatement.execute();
        createStatement.close();

    }
        private void hallet (boolean value,int uyenumarasi) {
        if (value) {
            sonuc.setText("Başarıyla Kayıt yapıldı");
            sonuc.setForeground(Color.blue);
            uyeno.setText("ÜYE NUMARANIZ : "+uyenumarasi);
            uyeno.setForeground(Color.blue);
            uyeno.setVisible(true);
            
        }
        else {
           
            sonuc.setText("Uygun telefon numarası veya referans giriniz");
            sonuc.setForeground(Color.RED);
        }
        sonuc.setVisible(true);
    }
      
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
            java.util.logging.Logger.getLogger(UyeOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UyeOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UyeOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UyeOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UyeOl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adisoyadi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JTextField referans;
    private javax.swing.JLabel sonuc;
    private javax.swing.JLabel uyeno;
    // End of variables declaration//GEN-END:variables
}
