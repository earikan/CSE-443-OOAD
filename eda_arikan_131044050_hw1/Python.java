/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author eda
 */
public class Python extends Snake {

    public Python() {
        stamina = 100;
        score = 0;
        length = 4;
        scoreFactor = 1;
    }

    @Override
    public String snakeName() {
        return "Python";
    }

}
