/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fox0fNight
 */
public class Student {

    private int idstudent;
    private String fullname;
    private String sdt;
    private String email;

    public Student() {
    }

    public Student(int idstudent, String fullname, String sdt, String email) {
        this.idstudent = idstudent;
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
    }

    public Student(String fullname, String sdt, String email) {
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
    }

    //Xây dựng hàm kết nối đến cơ sở dữ liệu
    public Connection lay_ket_noi_csdl() {
        //Code của bạn ở đây
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root", "qqq111");
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (conn);
    }

    //Xây dựng hàm thêm 1 student vào database
    public void save_student_to_db() {
        try {
            //Code của bạn ở đây
            String sql = "INSERT INTO studentmodel (fullname,sdt,email) VALUE(?,?,?)";
            PreparedStatement st = lay_ket_noi_csdl().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Hàm lấy ra danh sách các sinh viên trong bang student
    public ArrayList<Student> lay_danh_sach_sinh_vien() {
        //code của bạn ở đây
        return null;
        //code của bạn ở đây
    }

    //Hàm cập nhật sinh viên hiện tại vào csdl
    public void update_current_student() {
        //code của bạn ở đây
    }

    //Hàm xóa sinh viên hiện tại ra khỏi csdl
    public void delete_current_student() {
        //code của bạn ở đây
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
