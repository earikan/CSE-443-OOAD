/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;

/**
 *
 * @author eda
 */
public abstract class Snake extends JFrame {

    protected String name = "snake";
    protected int stamina = 100;
    protected int score = 0;
    protected int length = 4;
    protected int scoreFactor = 1;

    /*get character name*/
    public String snakeName() {
        return name;
    }

    /*get score multiplier*/
    public double getMultiplier() {
        return scoreFactor;
    }

    public int getStamina() {
        return stamina;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLength() {
        return length;
    }

}
