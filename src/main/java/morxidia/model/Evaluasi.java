/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package morxidia.model;

/**
 *
 * @author Lab Informatika
 */
public class Evaluasi {

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getDivisi() {
        return Divisi;
    }

    public void setDivisi(String Divisi) {
        this.Divisi = Divisi;
    }

    public float getNilai_target() {
        return nilai_target;
    }

    public void setNilai_target(float nilai_target) {
        this.nilai_target = nilai_target;
    }

    public float getNilai_disiplin() {
        return nilai_disiplin;
    }

    public void setNilai_disiplin(float nilai_disiplin) {
        this.nilai_disiplin = nilai_disiplin;
    }

    public float getNilai_inovasi() {
        return nilai_inovasi;
    }

    public void setNilai_inovasi(float nilai_inovasi) {
        this.nilai_inovasi = nilai_inovasi;
    }

    public float getNilai_akhir() {
        return nilai_akhir;
    }

    public void setNilai_akhir(float nilai_akhir) {
        this.nilai_akhir = nilai_akhir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private int idKaryawan;
    private String Nama;
    private String Divisi;
    private float nilai_target;
    private float nilai_disiplin;
    private float nilai_inovasi;
    private float nilai_akhir;
    private String status;
    
    public Evaluasi(){}
    
    public Evaluasi(
     int idKaryawan,
     String Nama,
     String Divisi,
     float nilai_target,
     float nilai_disiplin,
     float nilai_inovasi,
     float nilai_akhir,
     String status){
        this.idKaryawan = idKaryawan;
        this.Nama = Nama;
        this.Divisi = Divisi;
        this.nilai_target = nilai_target;
        this.nilai_disiplin = nilai_disiplin;
        this.nilai_inovasi = nilai_inovasi;
        this.nilai_akhir = nilai_akhir;
        this.status = status;
    }
    
}
