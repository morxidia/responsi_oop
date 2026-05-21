/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package morxidia.controller;

/**
 *
 * @author Lab Informatika
 */

import morxidia.model.Evaluasi;
import morxidia.model.EvaluasiDAO;
import morxidia.responsioop.view.ViewData;


import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KaryawanController {
    private EvaluasiDAO dao;
    private ViewData view;
    
    public KaryawanController(EvaluasiDAO dao, ViewData view) throws SQLException{
        this.dao = dao;
        this.view = view;
        
        refreshTable();
        
        this.view.addTambahListener(new TambahListener());
        this.view.addUpdateListener(new UpdateListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addClearListener(e -> view.clearInput());
        
        this.view.addTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int row = view.getTable().getSelectedRow();
                if(row != -1){
                    String id = view.getTableModel().getValueAt(row, 0).toString();
                    String nama = view.getTableModel().getValueAt(row, 1).toString(); 
                    String divisi = view.getTableModel().getValueAt(row, 2).toString(); 
                    String nilai_target = view.getTableModel().getValueAt(row, 3).toString(); 
                    String nilai_disiplin = view.getTableModel().getValueAt(row, 4).toString(); 
                    String nilai_inovasi = view.getTableModel().getValueAt(row, 5).toString(); 
                }
            }
        });
    }
    
    private void refreshTable() throws SQLException{
        view.getTableModel().setRowCount(0);
        List<Evaluasi> evaluasi_list = dao.getAllEvaluasi();
        for(Evaluasi eval : evaluasi_list){
            Object[] row = {eval.getIdKaryawan(), eval.getNama(), eval.getDivisi(), eval.getNilai_target(), eval.getNilai_disiplin(), eval.getNilai_inovasi(), eval.getNilai_akhir(), eval.getStatus()};
            view.getTableModel().addRow(row);
        }
    }

    class TambahListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String nama = view.getNamaInput();
                String divisi = view.getDivisi();
                float nilaiTarget = Float.parseFloat(view.getNilaiTarget());
                float nilaiDisiplin = Float.parseFloat(view.getNilai_disiplin());
                float nilaiInovasi = Float.parseFloat(view.getNilai_inovasi());
                if (nilaiTarget > 100) {
                    throw new IllegalArgumentException("Nilai Target " + nilaiTarget + " lebih dari 100");
                } else if (nilaiDisiplin > 100) {
                    throw new IllegalArgumentException("Nilai Disiplin " + nilaiDisiplin + " lebih dari 100");
                } else if (nilaiInovasi > 100) {
                    throw new IllegalArgumentException("Nilai Inovasi " + nilaiInovasi + " lebih dari 100");
                }
                float nilaiAkhir = (nilaiTarget*0.5f) + (nilaiDisiplin*0.3f) + (nilaiInovasi*0.2f);
                String status = "";
                if("Divisi Teknis".equals(divisi) && (nilaiAkhir >= 80.0)){
                    status = "PROMOSI";
                }
                else if("Divisi Pemasaran".equals(divisi) && (nilaiAkhir >= 85.0)){
                    status = "PROMOSI";
                }
                else{
                    status = "TETAP";
                }
                
                Evaluasi evaluasi = new Evaluasi(0,nama, divisi, nilaiTarget, nilaiDisiplin, nilaiInovasi, nilaiAkhir, status);
                
                dao.insertEvaluasi(evaluasi);
                JOptionPane.showMessageDialog(view, "data Berhasil ditambah");
                refreshTable();
                view.clearInput();
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(view, "Nilai Input salah", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Batas Nilai", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class DeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                int row = view.getTable().getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(view, "Pilihan data tidak sesuai");
                }
                int id = Integer.parseInt(view.getTableModel().getValueAt(row, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(view, "Apakah yakin ingin dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION){
                    dao.deleteEvaluasi(id);
                    JOptionPane.showMessageDialog(view, "data Berhasil Dihapus");
                    refreshTable();
                    view.clearInput();
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(view, "Nilai Input salah", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class UpdateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                int row = view.getTable().getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(view, "Pilihan data tidak sesuai");
                }
                int id;
                id = Integer.parseInt((view.getTableModel().getValueAt(row, 0)).toString());
                
                String nama = view.getNamaInput();
                String divisi = view.getDivisi();
                float nilaiTarget = Float.parseFloat(view.getNilaiTarget());
                float nilaiDisiplin = Float.parseFloat(view.getNilai_disiplin());
                float nilaiInovasi = Float.parseFloat(view.getNilai_inovasi());
                if (nilaiTarget > 100) {
                    throw new IllegalArgumentException("Nilai Target " + nilaiTarget + " lebih dari 100");
                } else if (nilaiDisiplin > 100) {
                    throw new IllegalArgumentException("Nilai Disiplin " + nilaiDisiplin + " lebih dari 100");
                } else if (nilaiInovasi > 100) {
                    throw new IllegalArgumentException("Nilai Inovasi " + nilaiInovasi + " lebih dari 100");
                }
                float nilaiAkhir = (nilaiTarget*0.5f) + (nilaiDisiplin*0.3f) + (nilaiInovasi*0.2f);
                String status = "";
                if("Divisi Teknis".equals(divisi) && (nilaiAkhir >= 80.0)){
                    status = "PROMOSI";
                }
                else if("Divisi Pemasaran".equals(divisi) && (nilaiAkhir >= 85.0)){
                    status = "PROMOSI";
                }
                else{
                    status = "TETAP";
                }
                
                Evaluasi evaluasi = new Evaluasi(id,nama, divisi, nilaiTarget, nilaiDisiplin, nilaiInovasi, nilaiAkhir, status);
                
                dao.updateEvaluasi(evaluasi);
                JOptionPane.showMessageDialog(view, "data Berhasil ditambah");
                refreshTable();
                view.clearInput();
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(view, "Nilai Input salah", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Batas Nilai", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
