/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parapuan.model;

/**
 *
 * @author stevie
 */
public class Musteri {
    private  int id;
    private String name;
    private String numara;
    private float parapuan;
    private int referansno;
    private int referansolan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public float getParapuan() {
        return parapuan;
    }

    public void setParapuan(float parapuan) {
        this.parapuan = parapuan;
    }

    public int getReferansno() {
        return referansno;
    }

    public void setReferansno(int referansno) {
        this.referansno = referansno;
    }

    public int getReferansolan() {
        return referansolan;
    }

    public void setReferansolan(int referansolan) {
        this.referansolan = referansolan;
    }

    @Override
    public String toString() {
        return "Musteri{" + "id=" + id + ", name=" + name + ", numara=" + numara + ", parapuan=" + parapuan + ", referansno=" + referansno + ", referansolan=" + referansolan + '}';
    }

  
    
}
