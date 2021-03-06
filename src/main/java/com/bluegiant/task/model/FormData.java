package com.bluegiant.task.model;

import com.bluegiant.task.model.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "FORM_DATA")
public class FormData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AD", length = 100)
    private String ad;

    @Column(name = "SOYAD", length = 100)
    private String soyad;

    @Column(name = "ADRES", length = 500)
    private String adres;

    @Column(name = "DOGUM_YERI", length = 100)
    private String dogumYeri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }
}
