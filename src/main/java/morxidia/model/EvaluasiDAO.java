/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package morxidia.model;

/**
 *
 * @author Lab Informatika
 */

import java.sql.*;
import java.util.*;
import morxidia.model.Evaluasi;

public class EvaluasiDAO {
    private String URL = "jdbc:mysql://localhost:3306/employee_db";
    private String USER = "root";
    private String PASSWORD = "";
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };
    
    public List<Evaluasi> getAllEvaluasi() throws SQLException{
        List<Evaluasi> evaluasi_list;
        evaluasi_list = new ArrayList<>();
        String query = "Select * from evaluasi";
        try(Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                Evaluasi evaluasi = new Evaluasi(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("divisi"),
                        rs.getFloat("nilai_target"),
                        rs.getFloat("nilai_disiplin"),
                        rs.getFloat("nilai_inovasi"),
                        rs.getFloat("nilai_akhir"),
                        rs.getString("status")
                );
                evaluasi_list.add(evaluasi);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return evaluasi_list;
    }
    
    public void insertEvaluasi(Evaluasi evaluasi) throws SQLException{
        String query = "INSERT INTO evaluasi(nama, divisi, nilai_target, nilai_disiplin, nilai_inovasi, nilai_akhir, status)VALUES(?,?,?,?,?,?,?)";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, evaluasi.getNama());
            ps.setString(2, evaluasi.getDivisi());
            ps.setFloat(3, evaluasi.getNilai_target());
            ps.setFloat(4, evaluasi.getNilai_disiplin());
            ps.setFloat(5, evaluasi.getNilai_inovasi());
            ps.setFloat(6, evaluasi.getNilai_akhir());
            ps.setString(7, evaluasi.getStatus());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateEvaluasi(Evaluasi evaluasi) throws SQLException{
        String query = "UPDATE evaluasi SET nama=?, divisi=?, nilai_target=?, nilai_disiplin=?, nilai_inovasi=?, nilai_akhir=?, status=? WHERE id=?";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, evaluasi.getNama());
            ps.setString(2, evaluasi.getDivisi());
            ps.setFloat(3, evaluasi.getNilai_target());
            ps.setFloat(4, evaluasi.getNilai_disiplin());
            ps.setFloat(5, evaluasi.getNilai_inovasi());
            ps.setFloat(6, evaluasi.getNilai_akhir());
            ps.setString(7, evaluasi.getStatus());
            ps.setInt(8, evaluasi.getIdKaryawan());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteEvaluasi(int evaluasiId) throws SQLException{
        String query = "DELETE FROM evaluasi WHERE id=?";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, evaluasiId);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
