//tambahin controller dan actionListener
package morxidia.responsioop.view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class ViewData extends JFrame {
    public JTable table;
    public JTextField tfId, tfNama, tfTarget, tfDisiplin, tfInovasi;
    public JComboBox<String> cbDivisi;
    public JButton btnAdd, btnUpdate, btnDelete, btnClear;
    public DefaultTableModel tableModel;

    public ViewData() {
        setTitle("Sistem Evaluasi Kinerja Karyawan");
        setSize(850, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        String[] column = {"ID", "Nama", "Divisi", "Target", "Disiplin", "Inovasi", "Nilai Akhir" , "Status"};
        tableModel = new DefaultTableModel(column, 0);
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 350);
        add(scrollPane);
        
        JLabel lNama = new JLabel("Nama Karyawan:");
        lNama.setBounds(600, 20, 150, 20);
        add(lNama);
        tfNama = new JTextField();
        tfNama.setBounds(600, 40, 200, 25);
        add(tfNama);

        JLabel lDivisi = new JLabel("Divisi:");
        lDivisi.setBounds(600, 70, 150, 20);
        add(lDivisi);
        cbDivisi = new JComboBox<>(new String[]{"Divisi Teknis", "Divisi Pemasaran"});
        cbDivisi.setBounds(600, 90, 200, 25);
        add(cbDivisi);

        JLabel lTarget = new JLabel("Nilai Target:");
        lTarget.setBounds(600, 120, 150, 20);
        add(lTarget);
        tfTarget = new JTextField();
        tfTarget.setBounds(600, 140, 200, 25);
        add(tfTarget);

        JLabel lDisiplin = new JLabel("Nilai Kedisiplinan:");
        lDisiplin.setBounds(600, 170, 150, 20);
        add(lDisiplin);
        tfDisiplin = new JTextField();
        tfDisiplin.setBounds(600, 190, 200, 25);
        add(tfDisiplin);

        JLabel lInovasi = new JLabel("Nilai Inovasi:");
        lInovasi.setBounds(600, 220, 150, 20);
        add(lInovasi);
        tfInovasi = new JTextField();
        tfInovasi.setBounds(600, 240, 200, 25);
        add(tfInovasi);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(600, 280, 90, 25);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(710, 280, 90, 25);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(600, 315, 90, 25);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(710, 315, 90, 25);
        add(btnClear);

        tfId = new JTextField(); // Hidden Field

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfId.setText(table.getValueAt(row, 0).toString());
                tfNama.setText(table.getValueAt(row, 1).toString());
                cbDivisi.setSelectedItem(table.getValueAt(row, 2).toString());
                tfTarget.setText(table.getValueAt(row, 3).toString());
                tfDisiplin.setText(table.getValueAt(row, 4).toString());
                tfInovasi.setText(table.getValueAt(row, 5).toString());
            }
        });
                

        setVisible(true);

        
        
    }
    
    public String getNamaInput(){
        return tfNama.getText();
    }
    
    public String getDivisi(){
        return cbDivisi.getPrototypeDisplayValue();
    }
    
    public String getNilaiTarget(){
        return tfTarget.getText();
    }
    
    public String getNilai_disiplin(){
        return tfDisiplin.getText();
    }
    
    public String getNilai_inovasi(){
        return tfInovasi.getText();
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public JTable getTable() {
        return table;
    }
    
    public void clearInput() {
        tfId.setText("");
        tfNama.setText("");
        tfTarget.setText("");
        tfDisiplin.setText("");
        tfInovasi.setText("");
    }
    
    public void addTambahListener(ActionListener listener){
        btnAdd.addActionListener(listener);
    }
    public void addUpdateListener(ActionListener listener){
        btnAdd.addActionListener(listener);
    }
    public void addDeleteListener(ActionListener listener){
        btnAdd.addActionListener(listener);
    }
    public void addClearListener(ActionListener listener){
        btnAdd.addActionListener(listener);
    }
    public void addTableMouseListener(MouseAdapter listener){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfId.setText(table.getValueAt(row, 0).toString());
                tfNama.setText(table.getValueAt(row, 1).toString());
                cbDivisi.setSelectedItem(table.getValueAt(row, 2).toString());
                tfTarget.setText(table.getValueAt(row, 3).toString());
                tfDisiplin.setText(table.getValueAt(row, 4).toString());
                tfInovasi.setText(table.getValueAt(row, 5).toString());
            }
        });
    }
}