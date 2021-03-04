/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong1.donglenh;

/**
 *
 * @author Fox0fNight
 */
public class Bai4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Shape ci = new Circle(5,1,2);
        System.out.println("Chu vi: "+ci.calcPerimeter());
        System.out.println("Dien tich: "+ci.calcArea());
        
        System.out.println(ci);
    }
    
}
