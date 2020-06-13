/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parapuan.model;

import java.util.Date;

/**
 *
 * @author stevie
 */
public class Odeme {
    private Date tarih;
    private float tutar;
    private String telno;

    public Date getTarih() {
        return tarih;
    }

    public float getTutar() {
        return tutar;
    }

    public String getTelno() {
        return telno;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public void setTutar(float tutar) {
        this.tutar = tutar;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    @Override
    public String toString() {
        return "Odeme{" + "tarih=" + tarih + ", tutar=" + tutar + ", telno=" + telno + '}';
    }
    
    
    
}
