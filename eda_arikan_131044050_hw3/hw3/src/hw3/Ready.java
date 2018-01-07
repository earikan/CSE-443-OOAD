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
public class Ready implements State {

    StudentLife studentLife;

    public Ready(StudentLife studentLife) {
        this.studentLife = studentLife;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You can't drink coffee, and can't work.");
    }

    @Override
    public void sleep() {
        System.out.println("You can't sleep.");
    }

    @Override
    public void outTillLate() {
        System.out.println("You need sleep now.");
        studentLife.setState(studentLife.getNeedingSleep());
    }

    @Override
    public void perseveranceAndHardwork() {
        System.out.println("You graduate!");
        studentLife.setState(studentLife.getGraduate());
    }

    @Override
    public void exercise() {
        System.out.println("You are fit!");
        studentLife.setState(studentLife.getFit());
    }

    @Override
    public void buyingAGTX1080Ti() {
        System.out.println("You are unable to become a rod for an axe -.-");
        studentLife.setState(studentLife.getUnableToBecomeARodForAnAxe());
    }

    @Override
    public void cheating() {
        System.out.println("You cheated.");
        studentLife.setState(studentLife.getUnableToBecomeARodForAnAxe());
    }

    public String toString() {
        return "ready";
    }
}
