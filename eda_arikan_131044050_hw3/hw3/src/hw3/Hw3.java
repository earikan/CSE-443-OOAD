/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

/**
 *
 * @author arika
 */
public class Hw3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StudentLife studentLife = new StudentLife();
        studentLife.outTillLate();
        studentLife.sleep();
        studentLife.exercise();
        studentLife.perseveranceAndHardwork();

        System.out.println("");

        StudentLife studentLife2 = new StudentLife();
        studentLife2.outTillLate();
        studentLife2.sleep();
        studentLife2.coffeeAndWork();
        studentLife2.perseveranceAndHardwork();

    }

}
