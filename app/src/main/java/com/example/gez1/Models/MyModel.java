package com.example.gez1.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyModel {
    @SerializedName("results")
    @Expose
    private ArrayList results;
    @SerializedName("yerID")
    @Expose
    private String yerID;
    @SerializedName("yerIsim")
    @Expose
    private String yerIsim;
    @SerializedName("yerAciklama")
    @Expose
    private String yerAciklama;
    @SerializedName("yerKonum")
    @Expose
    private String yerKonum;
    @SerializedName("yerKategori")
    @Expose
    private String yerKategori;
    @SerializedName("yerResim")
    @Expose
    private String yerResim;

    public ArrayList getResults() {
        return results;
    }

    public void setResults(ArrayList results) {
        this.results = results;
    }

    public String getYerID() {
        return yerID;
    }

    public void setYerID(String yerID) {
        this.yerID = yerID;
    }

    public String getYerIsim() {
        return yerIsim;
    }

    public void setYerIsim(String yerIsim) {
        this.yerIsim = yerIsim;
    }

    public String getYerAciklama() {
        return yerAciklama;
    }

    public void setYerAciklama(String yerAciklama) {
        this.yerAciklama = yerAciklama;
    }

    public String getYerKonum() {
        return yerKonum;
    }

    public void setYerKonum(String yerKonum) {
        this.yerKonum = yerKonum;
    }

    public String getYerKategori() {
        return yerKategori;
    }

    public void setYerKategori(String kategori) {
        this.yerIsim = kategori;
    }

    public String getYerResim() {
        return yerResim;
    }

    public void setYerResim(String yerResim) {
        this.yerResim = yerResim;
    }


    public MyModel(ArrayList results, String yerID, String yerIsim, String yerAciklama, String yerKonum, String yerKategori, String yerResim) {
        this.results = results;
        this.yerID = yerID;
        this.yerIsim = yerIsim;
        this.yerAciklama = yerAciklama;
        this.yerKonum = yerKonum;
        this.yerKategori = yerKategori;
        this.yerResim = yerResim;
    }
}
