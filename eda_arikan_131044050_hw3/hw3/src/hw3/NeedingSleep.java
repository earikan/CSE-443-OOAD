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
public class NeedingSleep implements State {

    StudentLife studentLife;

    public NeedingSleep(StudentLife studentLife) {
        this.studentLife = studentLife;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("Why didn't you rest? Now you have chronic illness.");
        studentLife.setState(studentLife.getChronicIllness());
    }

    @Override
    public void sleep() {
        System.out.println("Sleep is a good solution to be ready! You are sleeping.");
        studentLife.setState(studentLife.getReady());
    }

    @Override
    public void outTillLate() {
        System.out.println("You do anything out till late.");
    }

    @Override
    public void perseveranceAndHardwork() {
        System.out.println("You can't hardwork. You need sleep.");
    }

    @Override
    public void exercise() {
        System.out.println("You can't do exercise. You need sleep.");
    }

    @Override
    public void buyingAGTX1080Ti() {
        System.out.println("You can't buy a GTX1080Ti. Also students are poor.");
    }

    @Override
    public void cheating() {
        System.out.println("You can't cheat.");
    }

    public String toString() {
        return "needing sleep";
    }
}
