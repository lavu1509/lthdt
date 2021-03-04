/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentMVC;

import java.util.ArrayList;

/**
 *
 * @author Fox0fNight
 */
public class StudentController {
    private Student student;
    private ArrayList<Student> students;
    private StudentView studentview;
    public StudentController() {
    }

    public StudentController(Student student) {
        this.student = student;
    }

    public StudentController(Student student, StudentView studentview) {
        this.student = student;
        this.studentview = studentview;
    }

    public StudentController(StudentView studentview) {
        this.studentview = studentview;
    }

    public StudentController(ArrayList<Student> students) {
        this.students = students;
    }
    
    public void nhapdulieuSV(){
        this.student = this.studentview.themSV();
    }
    public void nhapdanhsachSV(){
        this.students = this.studentview.nhapdanhsachSV();
    }
    public void hienthiSV(){
        this.studentview.hienthiSV(this.student);
    }
    public void hienthidanhsachSV(){
        this.studentview.hienthidanhsachSV(students);
    }
    public void timkiemsvtheosdt(){
        this.studentview.timSV(students);
    }
}

