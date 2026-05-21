/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package morxidia.responsioop;
import morxidia.responsioop.view.ViewData;
import morxidia.responsioop.view.ViewData;
import morxidia.model.EvaluasiDAO;
import morxidia.controller.KaryawanController;
import java.sql.SQLException;
/**
 *
 * @author Lab Informatika
 */
public class ResponsiOOP {
    public static void main(String[] args) {
        try {
            ViewData view = new ViewData();
            EvaluasiDAO dao = new EvaluasiDAO();
            new KaryawanController(dao, view);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
