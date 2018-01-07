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
public class Graduate implements State {

    StudentLife studentLife;

    public Graduate(StudentLife studentLife) {
        this.studentLife = studentLife;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You can't drink any coffee, and can't work.");
    }

    @Override
    public void sleep() {
        System.out.println("You can't sleep.");
    }

    @Override
    public void outTillLate() {
        System.out.println("You do anything out till late.");
    }

    @Override
    public void perseveranceAndHardwork() {
        System.out.println("You can't have any perseverance and can't hard work.");
    }

    @Override
    public void exercise() {
        System.out.println("You can't make exercise.");
    }

    @Override
    public void buyingAGTX1080Ti() {
        System.out.println("You can't buy a new GTX1080Ti. Also students are poor.");
    }

    @Override
    public void cheating() {
        System.out.println("You can't cheat.");
    }

    public String toString() {
        return "graduate";
    }
}
