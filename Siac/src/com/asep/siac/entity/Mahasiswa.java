/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asep.siac.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Mahasiswa {
    @TableColumn(name="Nim", number=1)
    private String nim;
    @TableColumn(name="Nama", number=2, size=50)
    private String nama;
    @TableColumn(name="Tempat Lahir", number=3, size=25)
    private String temptLahir;
    @TableColumn(name="Tanggal Lahir", number=4)
    private Date tglLahir;
    @TableColumn(name="Telepon", number=5)
    private String telepon;
    @TableColumn(name="Alamat", number=6, size=50)
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getTemptLahir() {
        return temptLahir;
    }

    public void setTemptLahir(String temptLahir) {
        this.temptLahir = temptLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mahasiswa other = (Mahasiswa) obj;
        if (!Objects.equals(this.nim, other.nim)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.temptLahir, other.temptLahir)) {
            return false;
        }
        if (!Objects.equals(this.tglLahir, other.tglLahir)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nim);
        hash = 97 * hash + Objects.hashCode(this.nama);
        hash = 97 * hash + Objects.hashCode(this.temptLahir);
        hash = 97 * hash + Objects.hashCode(this.tglLahir);
        hash = 97 * hash + Objects.hashCode(this.telepon);
        hash = 97 * hash + Objects.hashCode(this.alamat);
        return hash;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", temptLahir=" + temptLahir + ", tglLahir=" + tglLahir + ", telepon=" + telepon + ", alamat=" + alamat + '}';
    }
    
}
