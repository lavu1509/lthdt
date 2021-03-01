/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.donglenh;

/**
 *
 * @author Fox0fNight
 */
public class Circle {
    private int radius;
    private int x,y;

    public Circle() {
    }

    public Circle(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    
    public double calcPerimeter(){
        double result = 2*Math.PI*this.radius;
        return result;
    }
    public double calcArea(){
        double result = Math.PI*this.radius*this.radius;
        return result;
    }
}
